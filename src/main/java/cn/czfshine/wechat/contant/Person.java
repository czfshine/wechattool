package cn.czfshine.wechat.contant;

/**
 * @author:czfshine
 * @date:2018/2/21 12:41
 */

public class Person extends Contact {

    private String wxid;
    private String remark;
    private String contactLabelIds;

    public Person(String uid, String nickname, String wxid, String remark, String contactLabelIds) {
        super(uid, nickname);
        this.wxid = wxid;
        this.remark = remark;
        this.contactLabelIds = contactLabelIds;
    }
}
