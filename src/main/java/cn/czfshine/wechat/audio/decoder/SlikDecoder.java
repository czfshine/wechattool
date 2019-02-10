package cn.czfshine.wechat.audio.decoder;


import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过调用外部的SlikDecoder对音频进行解码
 */
public class SlikDecoder {

    private Logger logger=LoggerFactory.getLogger("Slik");
    private String decoderPath; //外部解码器的路径
    private String ffmpegPath;
    private String tempPath="./temp.pcm";
    private boolean canDecode=false;
    public SlikDecoder(String decoderPath, String ffmpegPath) {
        this.decoderPath = decoderPath;
        this.ffmpegPath = ffmpegPath;
        if(!CheckDecoder()){
            logger.warn("Slik 解码器未找到或无法使用,请阅读README文档");
        }
        if(!CheckFFmpeg()){
            logger.warn("FFmpeg 未找到或无法使用,请阅读README文档或者搜索ffmpeg的使用教程");
        }
    }

    public ProcessBuilder getDecoderProcess(String infile) throws IOException {
        return new ProcessBuilder(decoderPath,infile,tempPath);
    }

    public ProcessBuilder getSlikFfmpegProcess(String outfile) throws IOException {
        return new ProcessBuilder(ffmpegPath,"-y","-f", "s16le", "-ar", "24000", "-ac", "1", "-i",
                tempPath,outfile);
    }

    public ProcessBuilder getAmrFfmpegProcess(String infile, String outfile) throws IOException {
        return new ProcessBuilder(ffmpegPath,"-y","-i",
                infile,outfile);
    }

    public boolean checkAmrFile(String infile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(infile));
        byte[] bytes = new byte[10];
        fileInputStream.readNBytes(bytes,0,10);
        fileInputStream.close();
        /*
            amr 文件以 #!AMR开头
         */
        if(bytes[2]=='A'){
            return true;
        }else{
            return false;
        }

    }
    /**
     * 解码文件(阻塞式)
     * 确保文件是 Slik v3格式的
     * @param infile 输出的文件路径
     * @param outfile 输出的文件路径
     * @return 是否成功
     */
    public boolean decodeSlik(String infile, String outfile){
        try {

            ProcessBuilder decoderProcess = getDecoderProcess(infile);
            safeRunProcess(decoderProcess);

            /*下面的代码会死锁
            decoderProcess.waitFor();
            decoderProcess.getErrorStream().readAllBytes();//?? todo :why?
            String s = new String(decoderProcess.getInputStream().readAllBytes());
            */

            if(!stdout.contains("File length:")){
                logger.warn("slik转换文件{}失败",infile);
                return false;
            }

            //要保证上一步成功,不然临时文件是上个音频的;
            ProcessBuilder ffmpegProcess = getSlikFfmpegProcess(outfile);
            return waitffmpeg(infile, ffmpegProcess);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 解码文件(阻塞式)
     * 确保文件是 AMR格式的
     * @param infile 输出的文件路径
     * @param outfile 输出的文件路径
     * @return 是否成功
     */
    public boolean decodeAmr(String infile,String outfile){
        try {
            ProcessBuilder ffmpegProcess = getAmrFfmpegProcess(infile,outfile);
            return waitffmpeg(infile, ffmpegProcess);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean waitffmpeg(String infile, ProcessBuilder ffmpegProcess) throws InterruptedException, IOException {

        safeRunProcess(ffmpegProcess);
        if(!stderr.contains("audio:")){
            logger.warn("ffmpeg转换文件{}失败",infile);
            return false;
        }
        return true;
    }

    /**
     * 解码文件(阻塞式)
     * 确保文件是 Slik v3格式的
     * @param infile 输出的文件路径
     * @param outfile 输出的文件路径
     * @return 是否成功
     */
    public boolean decode(String infile, String outfile) {
        try {
            if(checkAmrFile(infile)){
                return decodeAmr(infile,outfile);
            }else{
                return decodeSlik(infile,outfile);
            }
        } catch (IOException e) {
            return false;
        }
    }

        /**
         * 解码文件(非阻塞式)
         * 确保文件是 Slik v3格式的
         * @param infile 输出的文件路径
         * @param outfile 输出的文件路径
         * @param Callback 回调函数
         * @return 是否成功
         */
    public boolean decodeSlik(String infile, String outfile, Runnable Callback){
        //throw new NotImplementedException();
        return false;
    }

    private boolean CheckDecoder(){
        return check(decoderPath);
    }

    private boolean CheckFFmpeg(){
        return check(ffmpegPath);
    }

    private boolean check(String path) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(path);
            Process start = processBuilder.start();
            InputStream inputStream = start.getInputStream();
            //System.out.println(new String(inputStream.readAllBytes()));

            Thread.sleep(100);
            if(inputStream.available()>10){
                return true;
            }
            InputStream errorStream = start.getErrorStream();
            if(errorStream.available()>10){
                return true;
            }

        } catch (IOException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        return false;
    }



    private String stdout;
    private String stderr;

    /**
     * 避免pipe死锁的运行某个程序
     * 阻塞到进程退出,程序输出在全局域内(stdin,stdout)
     * https://blog.csdn.net/sj13051180/article/details/47865803
     * @param pb
     */
    private void safeRunProcess(ProcessBuilder pb) throws IOException, InterruptedException {
        //运行程序
        Process process = pb.start();
        //处理InputStream的线程
        Thread thread = new Thread(() -> {
            stdout = "";
            try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line = null;
                while ((line = in.readLine()) != null) {
                    stdout += line;
                }
            } catch (IOException ignored) {
            }
        });
        thread.start();
        //处理error的
        Thread thread1 = new Thread(() -> {
            stderr = "";

            try (BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                String line = null;
                while ((line = err.readLine()) != null) {
                    stderr += line;
                }
            } catch (IOException ignored) {

            }
        });
        thread1.start();
        thread.join();
        thread1.join();
        process.waitFor();
    }
}
