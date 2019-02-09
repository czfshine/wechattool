package cn.czfshine.wechat.database.pojo;


public class GameRawMessage {

  private String msgId;
  private String mergerId;
  private String gameMsgId;
  private long msgType;
  private String createTime;
  private String expireTime;
  private String appId;
  private long showInMsgList;
  private long isRead;
  private String label;
  private long isHidden;
  private String weight;
  private String rawXml;
  private String receiveTime;


  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }


  public String getMergerId() {
    return mergerId;
  }

  public void setMergerId(String mergerId) {
    this.mergerId = mergerId;
  }


  public String getGameMsgId() {
    return gameMsgId;
  }

  public void setGameMsgId(String gameMsgId) {
    this.gameMsgId = gameMsgId;
  }


  public long getMsgType() {
    return msgType;
  }

  public void setMsgType(long msgType) {
    this.msgType = msgType;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public long getShowInMsgList() {
    return showInMsgList;
  }

  public void setShowInMsgList(long showInMsgList) {
    this.showInMsgList = showInMsgList;
  }


  public long getIsRead() {
    return isRead;
  }

  public void setIsRead(long isRead) {
    this.isRead = isRead;
  }


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public long getIsHidden() {
    return isHidden;
  }

  public void setIsHidden(long isHidden) {
    this.isHidden = isHidden;
  }


  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }


  public String getRawXml() {
    return rawXml;
  }

  public void setRawXml(String rawXml) {
    this.rawXml = rawXml;
  }


  public String getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(String receiveTime) {
    this.receiveTime = receiveTime;
  }

}
