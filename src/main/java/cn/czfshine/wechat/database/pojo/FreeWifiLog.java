package cn.czfshine.wechat.database.pojo;


public class FreeWifiLog {

  private String id;
  private long protocolNumber;
  private String logContent;
  private String createTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public long getProtocolNumber() {
    return protocolNumber;
  }

  public void setProtocolNumber(long protocolNumber) {
    this.protocolNumber = protocolNumber;
  }


  public String getLogContent() {
    return logContent;
  }

  public void setLogContent(String logContent) {
    this.logContent = logContent;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

}
