package cn.czfshine.wechat.contant;

import java.util.List;

/**
 * 指一个群
 * @author:czfshine
 * @date:2018/2/21 12:37
 */

public class GroupChatroom extends Chatroom {
    public GroupChatroom(String uid, String nickname) {
        super(uid,  nickname);
    }
    private List<Talker> members;

    public List<Talker> getMembers() {
        return members;
    }

    public List<Talker> getTalkers() {
        return talkers;
    }

    private List<Talker> talkers;


    public void AddMember(Talker member){
        members.add(member);
    }

    public void AddTalker(Talker talker){
        talkers.add(talker);
    }

    @Override
    public String toString() {
        return "GroupChatroom{" +
                "members=" + members +
                ", talkers=" + talkers +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
