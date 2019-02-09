package cn.czfshine.wechat.database.pojo;


public class FmessageMsginfo {

  private String msgContent;
  private long isSend;
  private String talker;
  private String encryptTalker;
  private String svrId;
  private long type;
  private String createTime;
  private String chatroomName;


  public String getMsgContent() {
    return msgContent;
  }

  public void setMsgContent(String msgContent) {
    this.msgContent = msgContent;
  }


  public long getIsSend() {
    return isSend;
  }

  public void setIsSend(long isSend) {
    this.isSend = isSend;
  }


  public String getTalker() {
    return talker;
  }

  public void setTalker(String talker) {
    this.talker = talker;
  }


  public String getEncryptTalker() {
    return encryptTalker;
  }

  public void setEncryptTalker(String encryptTalker) {
    this.encryptTalker = encryptTalker;
  }


  public String getSvrId() {
    return svrId;
  }

  public void setSvrId(String svrId) {
    this.svrId = svrId;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getChatroomName() {
    return chatroomName;
  }

  public void setChatroomName(String chatroomName) {
    this.chatroomName = chatroomName;
  }

}
