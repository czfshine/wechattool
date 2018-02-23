package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.Message;

import java.io.*;

/**
 * @author:czfshine
 * @date:2018/2/21 10:45
 */

public class TextOutput {
    public static void toTextFile(Message[] msgs){
        try(FileWriter fos=new FileWriter( new File("testoutput.txt"));) {
            int len=msgs.length;
            for(int i=0;i<len;i++){
                try {
                    fos.write(msgs[i].toString());
                    fos.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ;
        } catch (IOException e) {
            e.printStackTrace();
            return ;
        }

    }
}
