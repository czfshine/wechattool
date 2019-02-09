package cn.czfshine.wechat.database.pojo;


public class DeletedConversationInfo {

  private String userName;
  private String lastSeq;
  private long reserved1;
  private String reserved2;
  private String reserved3;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getLastSeq() {
    return lastSeq;
  }

  public void setLastSeq(String lastSeq) {
    this.lastSeq = lastSeq;
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

}
