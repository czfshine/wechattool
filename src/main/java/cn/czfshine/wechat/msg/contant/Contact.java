package cn.czfshine.wechat.msg.contant;

import cn.czfshine.wechat.msg.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 对话对象，指代一个会话，包括朋友，群组，公众号，服务号等
 * @author:czfshine
 * @date:2018/2/9 22:27
 */

public class Contact {
    protected  String uid; //唯一标识符
    protected  String nickname; //昵称
    protected List<Message> messages=new ArrayList<>();

    public Contact(String uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }

    public void addMessage(Message msg){
        messages.add(msg);
    }

    public String getUid() {
        return uid;
    }
    public String getNickname() {
        return nickname;
    }
}
