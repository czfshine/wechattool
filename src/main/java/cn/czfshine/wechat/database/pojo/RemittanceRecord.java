package cn.czfshine.wechat.database.pojo;


public class RemittanceRecord {

  private String transferId;
  private String locaMsgId;
  private long receiveStatus;
  private long isSend;


  public String getTransferId() {
    return transferId;
  }

  public void setTransferId(String transferId) {
    this.transferId = transferId;
  }


  public String getLocaMsgId() {
    return locaMsgId;
  }

  public void setLocaMsgId(String locaMsgId) {
    this.locaMsgId = locaMsgId;
  }


  public long getReceiveStatus() {
    return receiveStatus;
  }

  public void setReceiveStatus(long receiveStatus) {
    this.receiveStatus = receiveStatus;
  }


  public long getIsSend() {
    return isSend;
  }

  public void setIsSend(long isSend) {
    this.isSend = isSend;
  }

}
