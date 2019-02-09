package cn.czfshine.wechat.database.pojo;


public class Oplog2 {

  private long id;
  private String inserTime;
  private long cmdId;
  private String buffer;
  private long reserved1;
  private String reserved2;
  private String reserved3;
  private String reserved4;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getInserTime() {
    return inserTime;
  }

  public void setInserTime(String inserTime) {
    this.inserTime = inserTime;
  }


  public long getCmdId() {
    return cmdId;
  }

  public void setCmdId(long cmdId) {
    this.cmdId = cmdId;
  }


  public String getBuffer() {
    return buffer;
  }

  public void setBuffer(String buffer) {
    this.buffer = buffer;
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
