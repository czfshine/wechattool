package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class MessageFactory {

     public static Logger logger;

    static {
        logger = LoggerFactory.getLogger("msgFACT");
    }

    public static BaseMessage getMessage(MessageDO messageDO) throws SQLException, UnknowMassageTypeException, DatabaseDamagedException {

        MSGTYPE msgtype=MSGTYPE.getType(messageDO.getType());
        if(msgtype.getClazz()!= UnknownMessage.class){
            try {
                return (BaseMessage) msgtype.getClazz().getConstructor(MessageDO.class).newInstance(messageDO);
            } catch (InstantiationException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }

        return null;
    }
}
