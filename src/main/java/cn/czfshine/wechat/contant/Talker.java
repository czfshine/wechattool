package cn.czfshine.wechat.contant;


import cn.czfshine.wechat.msg.BaseMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Talker {


    private String username;
    private String nickname;
    private String remark;
    private List<String> labels;
    private String wxid;

    protected Set<BaseMessage> messages;

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
        {
            Talker talker = new Talker(username);
            allTalker.put(username, talker);
            return talker;
        }
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
    public static void removeInstance(String username){
        allTalker.remove(username);
    }

    public List<BaseMessage> getMessages() {
        return messages.stream().collect(Collectors.toList());
    }

    public void addMessage(BaseMessage msg){
        messages.add(msg);
    }
    private Talker(String username, String nickname, String remark, String wxid) {
        this.username = username;
        this.nickname = nickname;
        this.remark = remark;
        this.wxid = wxid;
        messages=new HashSet<>(1000);

    }

    /**
     * 单纯使用用户名构建talker
     * 主要是解析消息时统一操作，理论上使用该方法创建的Talker都是群，
     * 也就是会被真正发送的用户覆盖，不会被使用，所以其他属性不要赋初值，
     * 假如抛出NPE，肯定出现逻辑错误了
     * @param username
     */
    private Talker(String username){
        this.username=username;
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
