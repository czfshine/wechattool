package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.BaseMessage;

import java.io.*;

/**
 * @author:czfshine
 * @date:2018/2/21 10:45
 */

public class TextOutput {
    public static void toTextFile(BaseMessage[] msgs, OutputStream file){
        System.out.println();
        try(BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(file)) {
            int len=msgs.length;
            for(int i=0;i<len;i++){
                try {
                    if(msgs[i] instanceof PlainTextable) {
                        bufferedOutputStream.write(((PlainTextable) msgs[i]).toPlainText().getBytes("UTF-8"));
                    }
                    bufferedOutputStream.write('\n');
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
