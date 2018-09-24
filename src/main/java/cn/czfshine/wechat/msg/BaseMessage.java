package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.ContactInfo;
import cn.czfshine.wechat.contant.ContactUID;
import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * @author :  czfshine
 * @date : 2018/1/16 22:19
 */

public abstract class BaseMessage implements Serializable {

    private static final long serialVersionUID = -2508535085230745489L;

    public long getMsgSvrId() {
        return msgSvrId;
    }

    protected long msgSvrId;

    public long getTime() {
        return time.getTime();
    }

    protected Date time;

    public ContactUID getTalker() {
        return talker;
    }

    protected ContactUID talker;

    public String getChatroom() {
        return chatroom;
    }

    protected String chatroom;

    BaseMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        msgSvrId=rs.getLong("msgSvrId");
        long datastamp=rs.getLong("createTime");
        time= new Date(datastamp);
        chatroom=rs.getString("talker");

        if(chatroom==null || "".equals(chatroom)) {
            throw  new DatabaseDamagedException();
        }
        talker = new ContactUID(chatroom);

        int isSend=rs.getInt(   "isSend");
        if(isSend==1){
            talker=ContactUID.ME;
        }

    }

    public BaseMessage(long msgSvrId, long datastamp, ContactUID talker, String chatroom) {
        this.msgSvrId = msgSvrId;
        time= new Date(datastamp);
        this.talker = talker;
        this.chatroom = chatroom;
    }

    protected static MSGTYPE TYPE;

    public  MSGTYPE getType() {
        try {
            return (MSGTYPE) this.getClass().getField("TYPE").get(this);
        } catch (NoSuchFieldException e) {
            System.out.println("没有TYPE域"+this.getClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 比较两条信息是否是同一条信息在不同数据库中重复了的。
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseMessage){
            BaseMessage b=(BaseMessage) obj;
            return this.time.equals(b.time) &&
                    this.talker.equals(b.talker);
        }
        return false;
    }

}
