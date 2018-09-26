package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class MessageFactory {
     public static BaseMessage getMessage(MessageDO messageDO) throws SQLException, UnknowMassageTypeException, DatabaseDamagedException {

        MSGTYPE msgtype=MSGTYPE.getType(messageDO.getType());
        if(msgtype.getClazz()!=UnknowMessage.class){
            try {
                return (BaseMessage) msgtype.getClazz().getConstructor(MessageDO.class).newInstance(messageDO);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
