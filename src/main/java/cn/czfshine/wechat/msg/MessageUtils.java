package cn.czfshine.wechat.msg;

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

}
