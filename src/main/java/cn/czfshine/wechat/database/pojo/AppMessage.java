package cn.czfshine.wechat.database.pojo;


public class AppMessage {

  private String msgId;
  private String xml;
  private String appId;
  private String title;
  private String description;
  private String source;
  private long type;


  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }


  public String getXml() {
    return xml;
  }

  public void setXml(String xml) {
    this.xml = xml;
  }


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }

}
