package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:czfshine
 * @date:2018/2/26 14:37
 */

public class MessageUtils {
    private  static  Logger logger= LoggerFactory.getLogger("msgutils");
    public static void statisType(BaseMessage[] msgs){
        Map<MSGTYPE,Integer> data = new HashMap<>(100);
        for (BaseMessage m :
                msgs) {
            data.put(m.getType(),data.getOrDefault(m.getType(),0)+1);
        }
        logger.info("消息类型统计:");

        for(Map.Entry<MSGTYPE, Integer> entry:data.entrySet()){
            logger.info("{}类型数量为：{}",entry.getKey(),entry.getValue());
        }


    }
    public static void statisType(List<BaseMessage> msgs) {
        statisType(msgs.toArray(new BaseMessage[msgs.size()]));
    }

    static int totalmsg;

    static int textmsg;
    static int oktextmsg;

    static int imgmsg;
    static int hasSmall;
    static int hasBIg;
    static int loseimg;

    static int othermsg;
    static int audiomsg;
    static int loseaudio;
    public static void CheckMessage(List<BaseMessage> msgs){

        for (BaseMessage b:msgs
             ) {

            if(b.talker!=null && b.chatroom!=null&&b.time!=null){
                totalmsg++;
            }else{
                System.out.println("消息信息缺失"+b.toString());
                continue;
            }
            if(b instanceof TextMessage){
                textmsg++;
                if(((TextMessage)b).getContent().length()>0){
                    oktextmsg++;
                }
            }else if(b instanceof ImageMessage){
                imgmsg++;

                ImageMessage im=(ImageMessage)b;
                Image image = im.getImage();
                if(image==null){
                    loseimg++;
                }else{
                    if(image.getBigImgPath()!=null){
                        hasBIg++;
                    }
                    if(image.getThumbImgPath()!=null){
                        hasSmall++;
                    }
                    if(image.getBigImgPath()==null && image.getThumbImgPath()==null){
                        loseimg++;
                    }
                }

            }else if (b instanceof AudioMessage){

                audiomsg++;
                if(((AudioMessage)b).getAudioPath()==null){
                    loseaudio++;
                }

            }else{
                othermsg++;
            }


        }

        System.out.println("消息的统计信息如下:");
        System.out.printf("一共%d条消息,其中基本消息完整的消息有%d条\n",msgs.size(),totalmsg);
        System.out.printf("文本消息共%d条,文本内容完整的有%d条\n",textmsg,oktextmsg);
        System.out.printf("图片消息一共%d条,原图存在的消息有%d条,预览图存在的有%d条,图片缺失的有%d条\n",
                imgmsg,hasBIg,hasSmall,loseimg);
        System.out.printf("语音信息一共%d条,缺失%d个音频文件\n",audiomsg,loseaudio);
    }
}
