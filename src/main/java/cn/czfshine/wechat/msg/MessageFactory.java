package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class MessageFactory {

    public static Logger logger;

    static {
        logger = LoggerFactory.getLogger("msgFACT");
    }

    public static Map<MessageDO,BaseMessage> allMessages;
    static {
        allMessages=new HashMap<>(100000);

    }

    public static BaseMessage getMessage(MessageDO messageDO) throws UnknowMassageTypeException {

        if(allMessages.containsKey(messageDO)){

            //既然已经存在，那么在某个chatroom或者talker的聊天列表里面就肯定存在这个对象，不必重新返回一次
            //logger.error("重复！");
            return null;
            //return allMessages.get(messageDO.getMsgSvrId());
        }


        MSGTYPE msgtype=MSGTYPE.getType(messageDO.getType());
        if(msgtype.getClazz()!= UnknownMessage.class){
            try {
                BaseMessage message=(BaseMessage) msgtype.getClazz().getConstructor(MessageDO.class).newInstance(messageDO);
                allMessages.put(messageDO,message);
                return message;
            } catch (Exception e){
                //理论上这一分支应该不会执行的：）
                //保证不会由于一条消息的错误使得程序终止，毕竟一条消息，who care？
                e.printStackTrace();
                logger.error("parse message error:{}"+e.getMessage(),messageDO);
            }
        }

        return null;
    }

    public static List<BaseMessage> listMessage(){
        ArrayList<BaseMessage> baseMessages = new ArrayList<>(allMessages.values());
        allMessages=null;
        return baseMessages;
    }
}
