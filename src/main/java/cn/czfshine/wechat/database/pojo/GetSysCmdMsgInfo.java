package cn.czfshine.wechat.database.pojo;


public class GetSysCmdMsgInfo {

  private String originSvrId;
  private String newMsgId;
  private String fromUserName;
  private String toUserName;
  private String createTime;
  private String content;
  private String msgSource;
  private long msgSeq;
  private long flag;
  private long reserved1;
  private String reserved2;
  private String reserved3;
  private String reserved4;


  public String getOriginSvrId() {
    return originSvrId;
  }

  public void setOriginSvrId(String originSvrId) {
    this.originSvrId = originSvrId;
  }


  public String getNewMsgId() {
    return newMsgId;
  }

  public void setNewMsgId(String newMsgId) {
    this.newMsgId = newMsgId;
  }


  public String getFromUserName() {
    return fromUserName;
  }

  public void setFromUserName(String fromUserName) {
    this.fromUserName = fromUserName;
  }


  public String getToUserName() {
    return toUserName;
  }

  public void setToUserName(String toUserName) {
    this.toUserName = toUserName;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getMsgSource() {
    return msgSource;
  }

  public void setMsgSource(String msgSource) {
    this.msgSource = msgSource;
  }


  public long getMsgSeq() {
    return msgSeq;
  }

  public void setMsgSeq(long msgSeq) {
    this.msgSeq = msgSeq;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }


  public long getReserved1() {
    return reserved1;
  }

  public void setReserved1(long reserved1) {
    this.reserved1 = reserved1;
  }


  public String getReserved2() {
    return reserved2;
  }

  public void setReserved2(String reserved2) {
    this.reserved2 = reserved2;
  }


  public String getReserved3() {
    return reserved3;
  }

  public void setReserved3(String reserved3) {
    this.reserved3 = reserved3;
  }


  public String getReserved4() {
    return reserved4;
  }

  public void setReserved4(String reserved4) {
    this.reserved4 = reserved4;
  }

}
