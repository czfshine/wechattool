package cn.czfshine.wechat.msg;

/**
 * 对话对象，指代一个会话，包括朋友，群组，公众号，服务号等
 * @author:czfshine
 * @date:2018/2/9 22:27
 */

public class Contact {
    private String uid; //唯一标识符
    private String wechatid; //微信号
    private String remark; //备注
    private String nickname; //昵称
    private int[] labellist; //标签列表

    public Contact(String uid, String wechatid, String remark, String nickname) {
        this.uid = uid;
        this.wechatid = wechatid;
        this.remark = remark;
        this.nickname = nickname;
    }

    public String getUid() {
        return uid;
    }

    public String getWechatid() {
        return wechatid;
    }

    public String getRemark() {
        return remark;
    }

    public String getNickname() {
        return nickname;
    }
}
