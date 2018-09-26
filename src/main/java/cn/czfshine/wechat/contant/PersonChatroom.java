package cn.czfshine.wechat.contant;

/**
 * 指普通用户会话
 * @author:czfshine
 * @date:2018/2/21 12:41
 */

public class PersonChatroom extends Chatroom {


    private Talker talker;
    public PersonChatroom(String uid, String nickname, Talker talker) {
        super(uid, nickname);
        this.talker=talker;

    }
    public Talker getTalker(){
        return talker;
    }

    @Override
    public String toString() {
        return "PersonChatroom{" +
                "talker=" + talker +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
