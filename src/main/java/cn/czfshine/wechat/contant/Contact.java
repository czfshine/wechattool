package cn.czfshine.wechat.contant;

import cn.czfshine.wechat.msg.BaseMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 对话对象，指代一个会话，包括朋友，群组，公众号，服务号等
 * @author:czfshine
 * @date:2018/2/9 22:27
 */

public class Contact implements Serializable {
    public  static final long serialVersionUID =1802252205;

    protected  String uid; //唯一标识符
    protected  String nickname; //昵称

    protected List<BaseMessage> messages=new ArrayList<>();


    /**
     * @return 得到该对话的所有消息
     */
    public List<BaseMessage> getMessages() {
        return messages;
    }


    public Contact(String uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }


    /**
     * 增加一条消息到该对话中去
     * @param msg 待增加的消息
     */
    public void addMessage(BaseMessage msg){
        messages.add(msg);
    }


    /**
     * 对当前的所有消息按时间排序
     */
    public void sortMessage(){
        messages.sort( Comparator.comparingLong((BaseMessage m)->m.getTime()));
    }

    public String getUid() {
        return uid;
    }
    public String getNickname() {
        return nickname;
    }
}
