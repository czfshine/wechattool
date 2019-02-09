package cn.czfshine.wechat.database.pojo;


public class RecordMessageInfo {

  private long localId;
  private String msgId;
  private String oriMsgId;
  private String toUser;
  private String title;
  private String desc;
  private String dataProto;
  private long type;
  private long status;
  private String favFrom;


  public long getLocalId() {
    return localId;
  }

  public void setLocalId(long localId) {
    this.localId = localId;
  }


  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }


  public String getOriMsgId() {
    return oriMsgId;
  }

  public void setOriMsgId(String oriMsgId) {
    this.oriMsgId = oriMsgId;
  }


  public String getToUser() {
    return toUser;
  }

  public void setToUser(String toUser) {
    this.toUser = toUser;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public String getDataProto() {
    return dataProto;
  }

  public void setDataProto(String dataProto) {
    this.dataProto = dataProto;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getFavFrom() {
    return favFrom;
  }

  public void setFavFrom(String favFrom) {
    this.favFrom = favFrom;
  }

}
