package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Chatroom;
import cn.czfshine.wechat.contant.ChatroomFactory;
import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static cn.czfshine.wechat.msg.MSGTYPE.TYPE_REDENVELOPE;


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

    public Talker getTalker() {
        return talker;
    }

    protected Talker talker;

    public Chatroom getChatroom() {
        return chatroom;
    }
    protected Chatroom chatroom;

    BaseMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        msgSvrId=messageDO.getMsgid();
        time= new Date(messageDO.getCreateTime());
        typeid=messageDO.getType();
        chatroom= ChatroomFactory.getChatroom(messageDO.getTalker());
        if(chatroom==null) {
            throw  new DatabaseDamagedException();
        }

        talker = Talker.getInstance(messageDO.getTalker());
        int isSend=messageDO.getIsSend();
        if(isSend==1){
            talker=Talker.getInstance("me");
        }

    }


    protected static MSGTYPE TYPE;
    protected int typeid;
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
            /*
            return this.time.equals(b.time) &&
                    this.talker.equals(b.talker);*/
        }
        return false;
    }
    protected String setTalker(String content){
        if(content==null) return null;
        if(!talker.getUsername().equals("me")){
            if(chatroom.getUid().endsWith("@chatroom")){
                if(!content.contains(":")){
                    talker=Talker.getInstance("me");
                    return content;
                }
                talker = Talker.getInstance(content.substring(0, content.indexOf(":")));
                if(talker.getUsername().equals(chatroom.getUid())){
                    //LoggerFactory.getLogger("funndy").warn("哇啊！微信群居然会发消息啦{}",this);
                    Talker.removeInstance(chatroom.getUid());
                    talker=Talker.getInstance(chatroom.getUid(),chatroom.getNickname(),
                            chatroom.getNickname(),chatroom.getUid());
                }
                String substring = content.substring(content.indexOf(":") + 2);
                if(substring.startsWith("wxid_")){
                    return substring.substring(substring.indexOf(":")+2);
                }
                return substring;
            }
        }else{
            if(content.startsWith("wxid_")) { //todo

                    if (!content.contains(":")) {
                        return content;
                    }
                    String substring = content.substring(content.indexOf(":") + 2);
                    if(substring.startsWith("wxid_")){
                        return substring.substring(substring.indexOf(":")+2);
                    }
                    return substring;

            }

        }
        return content;
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "msgSvrId=" + msgSvrId +
                ", time=" + time +
                ", talker=" + talker +
                ", chatroom=" + chatroom +
                '}';
    }
}
