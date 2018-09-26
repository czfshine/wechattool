package cn.czfshine.wechat.contant;

import cn.czfshine.wechat.database.pojo.RContactDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatroomFactory {
    private static Map<String,Chatroom> allChatroom;

    static {
        allChatroom=new HashMap<>(100);
    }
    public static Chatroom getChatroom(String username){
        return allChatroom.getOrDefault(username,null);
    }

    public static Chatroom getChatroom(RContactDO rc){

        Chatroom res;
        if (rc.getUsername().endsWith("@chatroom")) { //微信群
            res= new GroupChatroom(rc.getUsername(), rc.getNickname());

        } else if (rc.getUsername().startsWith("gh_")) { //服务号
            res=new ServiceChatroom(rc.getUsername(), rc.getNickname());

        } else { //其他的假设是个人聊天
            res=new PersonChatroom(rc.getUsername(), rc.getNickname(),
                    Talker.getInstance(rc.getUsername(),rc.getNickname(),
                            rc.getConRemark(),
                            rc.getAlias()));
        }
        allChatroom.put(rc.getUsername(),res);
        return res;
    }
    public static Map<String,Chatroom> getAllChatroom(){
        return  allChatroom;
    }
}
