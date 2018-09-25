package cn.czfshine.wechat.contant;

/**
 * 指普通用户会话
 * @author:czfshine
 * @date:2018/2/21 12:41
 */

public class PersonChatroom extends Chatroom {

    private String wxid;
    private String remark; //备注
    private String contactLabelIds; //标签列表

    private Talker talker;
    public PersonChatroom(String uid, String nickname, String wxid, String remark, String contactLabelIds) {
        super(uid, nickname);
        this.wxid = wxid;
        this.remark = remark;
        this.contactLabelIds = contactLabelIds;
    }

    @Override
    public String getNickname() {
        if(remark.length()!=0){
            return remark;
        }
        return super.getNickname();
    }

    public Talker getTalker(){
        return talker;
    }
}
