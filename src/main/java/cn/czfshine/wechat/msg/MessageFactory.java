package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class MessageFactory {
     public static BaseMessage getMessage(ResultSet rs) throws SQLException, UnknowMassageTypeException, DatabaseDamagedException {
        int type= rs.getInt("type");
        MSGTYPE msgtype=MSGTYPE.getType(type);
        if(msgtype.getClazz()!=UnknowMessage.class){
            try {
                return (BaseMessage) msgtype.getClazz().getConstructor(ResultSet.class).newInstance(rs);
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
