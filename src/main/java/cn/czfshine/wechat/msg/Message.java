package cn.czfshine.wechat.msg;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;


/**
 * @author :  czfshine
 * @date : 2018/1/16 22:19
 */

public abstract class Message implements Serializable {

    private static final long serialVersionUID = -2508535085230745489L;
    protected long msgSvrId;

    public Date getTime() {
        return time;
    }

    protected Date time;

    public String getTalker() {
        return talker;
    }

    protected String talker;

    public String getChatroom() {
        return chatroom;
    }

    protected String chatroom;

    Message(ResultSet rs) throws SQLException, DatabaseDamagedException {
        msgSvrId=rs.getLong("msgSvrId");
        long datastamp=rs.getLong("createTime");
        time= new Date(datastamp);
        chatroom=rs.getString("talker");
        if(chatroom==null ||chatroom.equals("")) {
            throw  new DatabaseDamagedException();
        }
        talker=chatroom;
        int isSend=rs.getInt(   "isSend");
        if(isSend==1){
            talker="me";
        }

    }

    public Message(long msgSvrId, long datastamp, String talker, String chatroom) {
        this.msgSvrId = msgSvrId;
        time= new Date(datastamp);
        this.talker = talker;
        this.chatroom = chatroom;
    }
}
