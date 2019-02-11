package cn.czfshine.wechat.resources;

import cn.czfshine.wechat.image.Image;
import cn.czfshine.wechat.msg.BaseMessage;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Resources  {

    private static Resources theRes;
    static {
        theRes=new Resources();
    }

    private Resources(){};

    public static Resources getResources() {
        return theRes;
    }

    /**增加资源目录到资源池
     * @param path 资源文件夹
     */
    public void addPath(String path){

    }

    /**增加归档文件（zip）到资源池
     * @param path  压缩文件路径
     */
    public void addArchive(String path){

    }

    public Image getImageByMd5(String md5){
        return null;
    }
    public Image getImageByMsgSvrId(long svrid){
        return null;
    }
    public Image getImageByMsg(BaseMessage msg){
        return null;
    }
    private String getMd5(String str){
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    private String[] voicePaths={"/home/czfshine/workplace/wechat/data/voice/"};

    private String checkVoiceFile(String md5,String imgpath){
        String level1=md5.substring(0,2);
        String level2=md5.substring(2,4);

        for(String path:voicePaths){
            File root = new File(path);
            File[] files = root.listFiles(File::isDirectory);
            if(files==null){
                continue;
            }
            for(File voiceroot :files ){
                String imagefilepath=voiceroot.getPath() + File.separator +
                        level1 + File.separator+
                        level2 + File.separator+
                        "msg_"+imgpath+".mp3";
                File imagefile = new File(imagefilepath);
                if (!imagefile.exists()) {
                    imagefilepath = voiceroot.getPath() + File.separator +
                            level1 + File.separator +
                            level2 + File.separator +
                            "msg_" + imgpath + ".amr";
                    imagefile = new File(imagefilepath);
                    if (imagefile.exists()) {
                        return imagefilepath;
                    }
                } else {
                    return imagefilepath;
                }

            }

        }
        return null;
    }
    public String getAudoByImgpath(String imgpath){
        String s = getMd5(imgpath);
        return checkVoiceFile(s,imgpath);
    }


}
