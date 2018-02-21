package cn.czfshine.wechat.msg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;


/**
 * @author :  czfshine
 * @date : 2018/1/16 22:19
 */

public abstract class Message {
    public  MSGTYPE TYPE;

    protected int msgSvrId;

    public Calendar getTime() {
        return time;
    }

    protected Calendar time;
    protected String talker;

    public String getChatroom() {
        return chatroom;
    }

    protected String chatroom;

    Message(ResultSet rs) throws SQLException, DatabaseDamagedException {
        msgSvrId=rs.getInt("msgSvrId");
        long datastamp=rs.getLong("createTime");
        time=Calendar.getInstance();
        time.setTime(new Date(Math.abs(datastamp)));
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



}
