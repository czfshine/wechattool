package cn.czfshine.wechat.emoji;

import java.io.*;

/**
 * 一些小脚本,解密微信的表情文件
 * 只能解决一部分
 */
public class DecryptTools {


    /**
     * 恢复png文件头
     * 微信把某些png的文件头改了,
     * 本来是89 50 4E 47 0D 0A 1A 0A
     * 文件是89 50 4E 47 0A 1A 0A
     * 补个0d就行.
     *
     * 适用于:
     * emoji文件夹下的各个
     *  ` com.tencent.xin.emoticon.person.stiker_xxxx` 文件夹下的
     *      `[某个md5]_cover`文件
     *
     *  解密后当然是静态的png图,对应的gif还没找到办法,不过至少能看到表情长什么样
     * @param infile
     * @param outfile
     * @throws IOException
     */
    public static void resumePngFile(String infile,String outfile) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(infile)));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(outfile)));
        byte [] head=new byte[4];

        bufferedInputStream.read(head,0,4);
        bufferedOutputStream.write(head);
        bufferedOutputStream.write(0x0d);
        bufferedOutputStream.write(bufferedInputStream.readAllBytes());
    }

    public static void main(String[] args) throws IOException {
        DecryptTools.resumePngFile("/home/czfshine/workplace/wechat/emoji/1.png",
                "/home/czfshine/workplace/wechat/emoji/1.out.png");
    }
}
