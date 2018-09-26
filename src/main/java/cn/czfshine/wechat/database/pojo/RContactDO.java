package cn.czfshine.wechat.database.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

@Table("rcontact")
public class RContactDO {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getConRemark() {
        return conRemark;
    }

    public void setConRemark(String conRemark) {
        this.conRemark = conRemark;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContactLabelIds() {
        return contactLabelIds;
    }

    public void setContactLabelIds(String contactLabelIds) {
        this.contactLabelIds = contactLabelIds;
    }

    @Column
    private String username;
    @Column
    private String alias;
    @Column
    private String conRemark;
    @Column
    private String nickname;
    @Column
    private int type;
    @Column
    private String contactLabelIds;

    @Override
    public String toString() {
        return "RContactDO{" +
                "username='" + username + '\'' +
                ", alias='" + alias + '\'' +
                ", conRemark='" + conRemark + '\'' +
                ", nickname='" + nickname + '\'' +
                ", type=" + type +
                ", contactLabelIds='" + contactLabelIds + '\'' +
                '}';
    }
}
