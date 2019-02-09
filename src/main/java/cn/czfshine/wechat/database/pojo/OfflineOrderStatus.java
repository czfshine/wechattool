package cn.czfshine.wechat.database.pojo;


public class OfflineOrderStatus {

  private String reqkey;
  private String ackKey;
  private long status;
  private String receiveTime;


  public String getReqkey() {
    return reqkey;
  }

  public void setReqkey(String reqkey) {
    this.reqkey = reqkey;
  }


  public String getAckKey() {
    return ackKey;
  }

  public void setAckKey(String ackKey) {
    this.ackKey = ackKey;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(String receiveTime) {
    this.receiveTime = receiveTime;
  }

}
