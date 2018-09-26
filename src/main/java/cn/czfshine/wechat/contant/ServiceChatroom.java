package cn.czfshine.wechat.contant;

/**
 * 公众号
 * @author:czfshine
 * @date:2018/2/21 12:40
 */

public class ServiceChatroom extends Chatroom {
    private Talker talker;
    public Talker getTalker()
    {
        return talker;
    }
    public ServiceChatroom(String uid, String nickname,Talker talker) {
        super(uid, nickname);
        this.talker=talker;
    }

    @Override
    public String toString() {
        return "ServiceChatroom{" +
                "talker=" + talker +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
