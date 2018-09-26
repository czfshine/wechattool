package cn.czfshine.wechat.contant;


import cn.czfshine.wechat.msg.BaseMessage;
import org.docx4j.openpackaging.Base;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Talker {


    private String username;
    private String nickname;
    private String remark;
    private List<String> labels;
    private String wxid;

    private List<BaseMessage> messages;

    private static Map<String ,Talker> allTalker;
    static {
        allTalker=new HashMap<>(1000);
        getInstance("me","myself","我自己","wxid_me");
        getInstance("system","system","系统","wxid_system");
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getRemark() {
        return remark;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getWxid() {
        return wxid;
    }

    public static Talker getInstance(String username){
        if(!allTalker.containsKey(username))
            LoggerFactory.getLogger("talker")
                    .warn("talker {} 没有注册,当前talker数量为{}",username,allTalker.size());
        return allTalker.getOrDefault(username,null);
    }

    public static Talker getInstance(String username, String nickname, String remark, String wxid) {
        if(allTalker.containsKey(username)){
            return allTalker.get(username);
        }else{
            Talker talker = new Talker(username, nickname, remark, wxid);
            allTalker.put(username,talker);
            return talker;
        }
    }

    public List<BaseMessage> getMessages() {
        return messages;
    }

    public void addMessage(BaseMessage msg){
        messages.add(msg);
    }
    private Talker(String username, String nickname, String remark, String wxid) {
        this.username = username;
        this.nickname = nickname;
        this.remark = remark;
        this.wxid = wxid;
        messages=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Talker{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", remark='" + remark + '\'' +
                ", labels=" + labels +
                ", wxid='" + wxid + '\'' +
                '}';
    }
}
