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
    public static void StatisType(Message[] msgs){
        Map<MSGTYPE,Integer> data = new HashMap<>();
        for (Message m :
                msgs) {
            data.put(m.getType(),data.getOrDefault(m.getType(),0)+1);
        }
        logger.info("消息类型统计:");
        for (MSGTYPE type:
             data.keySet()) {
            logger.info("{}类型数量为：{}",type,data.get(type));
        }

    }
    public static void StatisType(List<Message> msgs) {
        StatisType(msgs.toArray(new Message[msgs.size()]));
    }
}
