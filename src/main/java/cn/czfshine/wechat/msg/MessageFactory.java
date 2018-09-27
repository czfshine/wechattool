package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
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

    public static Map<Long,BaseMessage> allMessages;
    public static Map<Long,MessageDO> allMsgDO;
    static {
        allMessages=new HashMap<>(100000);
        allMsgDO=new HashMap<>(100000);
    }

    public static BaseMessage getMessage(MessageDO messageDO) throws UnknowMassageTypeException {

        if(allMessages.containsKey(messageDO.getMsgSvrId())){

            if(allMsgDO.get(messageDO.getMsgSvrId()).equals(messageDO)){
                return allMessages.get(messageDO.getMsgSvrId());
            }
            else {
                //这种情况应该是错误而不是警告，因为数据一致性已经被破坏，后续处理可能出错
                logger.error("有两条消息的SVRID:{}一样，但是DO不一样:{}-{}",
                        messageDO.getMsgSvrId(),messageDO,allMsgDO.get(messageDO.getMsgSvrId()));
                //为了数据完整性，即使这样也还是让它创建一个新的message，然后覆盖map里原来的message
            }
        }


        MSGTYPE msgtype=MSGTYPE.getType(messageDO.getType());
        if(msgtype.getClazz()!= UnknownMessage.class){
            try {
                BaseMessage message=(BaseMessage) msgtype.getClazz().getConstructor(MessageDO.class).newInstance(messageDO);
                allMessages.put(messageDO.getMsgSvrId(),message);
                allMsgDO.put(messageDO.getMsgSvrId(),messageDO);
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
}
