package cn.czfshine.wechat.database.pojo;


public class IpCallMsg {

  private String svrId;
  private String isRead;
  private String title;
  private String content;
  private String pushTime;
  private long msgType;
  private String descUrl;


  public String getSvrId() {
    return svrId;
  }

  public void setSvrId(String svrId) {
    this.svrId = svrId;
  }


  public String getIsRead() {
    return isRead;
  }

  public void setIsRead(String isRead) {
    this.isRead = isRead;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getPushTime() {
    return pushTime;
  }

  public void setPushTime(String pushTime) {
    this.pushTime = pushTime;
  }


  public long getMsgType() {
    return msgType;
  }

  public void setMsgType(long msgType) {
    this.msgType = msgType;
  }


  public String getDescUrl() {
    return descUrl;
  }

  public void setDescUrl(String descUrl) {
    this.descUrl = descUrl;
  }

}
