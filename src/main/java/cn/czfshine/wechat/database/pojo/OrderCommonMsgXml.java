package cn.czfshine.wechat.database.pojo;


public class OrderCommonMsgXml {

  private String msgId;
  private String msgContentXml;
  private String isRead;


  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }


  public String getMsgContentXml() {
    return msgContentXml;
  }

  public void setMsgContentXml(String msgContentXml) {
    this.msgContentXml = msgContentXml;
  }


  public String getIsRead() {
    return isRead;
  }

  public void setIsRead(String isRead) {
    this.isRead = isRead;
  }

}
