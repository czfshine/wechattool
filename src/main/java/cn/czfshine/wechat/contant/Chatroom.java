package cn.czfshine.wechat.contant;

import cn.czfshine.wechat.msg.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 对话对象，指代一个会话，包括朋友，群组，公众号，服务号等
 * @author:czfshine
 * @date:2018/2/9 22:27
 */

public class Chatroom implements Serializable {
    public  static final long serialVersionUID =1802252205;

    protected  String uid; //唯一标识符
    protected  String nickname; //昵称

    protected Set<BaseMessage> messages=new HashSet<>(1000);


    /**
     * @return 得到该对话的所有消息
     */
    public List<BaseMessage> getMessages() {
        return messages.stream().collect(Collectors.toList());
    }


    public Chatroom(String uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }


    /**
     * 增加一条消息到该对话中去
     * @param msg 待增加的消息
     */
    public void addMessage(BaseMessage msg){

        if(!messages.contains(msg))
            messages.add(msg);
    }


    /**
     * 对当前的所有消息按时间排序
     */
    //private void sortMessage(){
    //    messages.sort( Comparator.comparingLong((BaseMessage m)->m.getTime()));
    //}

    public String getUid() {
        return uid;
    }
    public String getNickname() {
        return nickname;
    }


    public enum CONTACTTYPE{
        SYSTEM, //系统
        SERVICE,//公众号
        APP,//应用
        SELF,//本人
        FRIEND,//朋友
        PERSON,//个人（非朋友）群友
        UNKONWN //未知类型
    }
    //todo:废弃
    public static  CONTACTTYPE getType(int type){
        Logger logger = LoggerFactory.getLogger("CONTYPE");
        switch (type){
            case 0:
                return CONTACTTYPE.SERVICE;
            case 1: return CONTACTTYPE.SELF;
            case 2: break;
            case 3:
                return CONTACTTYPE.SERVICE;
            case 4: break;

            case 33:
                return CONTACTTYPE.APP;

            default:logger.warn("未知用户类型{}",type); return CONTACTTYPE.UNKONWN;
        }
        return CONTACTTYPE.UNKONWN;
    }
}
