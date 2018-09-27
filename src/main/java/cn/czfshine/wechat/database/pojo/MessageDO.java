package cn.czfshine.wechat.database.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Objects;

@Table("message")
public class MessageDO {

    @Id
    private  int msgid;

    @Column
    private long msgSvrId;

    @Column
    private int type;

    @Column
    private int isSend;

    @Column
    private long createTime;

    @Column
    private String talker;

    @Column
    private String content;

    @Column
    private String imgPath;

    public int getMsgid() {
        return msgid;
    }

    public void setMsgid(int msgid) {
        this.msgid = msgid;
    }

    public long getMsgSvrId() {
        return msgSvrId;
    }

    public void setMsgSvrId(long msgSvrId) {
        this.msgSvrId = msgSvrId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "MessageDO{" +
                "msgid=" + msgid +
                ", type=" + type +
                ", isSend=" + isSend +
                ", createTime=" + createTime +
                ", talker='" + talker + '\'' +
                ", content='" + content + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDO messageDO = (MessageDO) o;
        return
                getMsgSvrId() == messageDO.getMsgSvrId() &&
                getType() == messageDO.getType() &&
                getIsSend() == messageDO.getIsSend() &&
                getCreateTime() == messageDO.getCreateTime() &&
                Objects.equals(getTalker(), messageDO.getTalker()) &&
                Objects.equals(getContent(), messageDO.getContent()) &&
                Objects.equals(getImgPath(), messageDO.getImgPath());
    }

    private int hash;
    private boolean cached=false;
    @Override
    public int hashCode() {
        if(cached==false){
            hash=Objects.hash(getMsgSvrId(), getType(),
                    getIsSend(), getCreateTime(), getTalker(), getContent(), getImgPath());
            cached=true;
        }
        return hash;
    }
}
