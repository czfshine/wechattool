package cn.czfshine.wechat.contant;


import cn.czfshine.wechat.msg.BaseMessage;
import org.docx4j.openpackaging.Base;

import java.util.List;

public class Talker {


    private String uid;

    private String nickname;

    private List<BaseMessage> messages;

    public String getNickname() {
        return nickname;
    }

    public List<BaseMessage> getMessages() {
        return messages;
    }

    public Talker(String uid) {
        this.uid = uid;

    }

    public String getUid(){
        return uid;
    }

    public static Talker ME= new Talker("me");

    public static Talker SYSTEM= new Talker("system");

}
