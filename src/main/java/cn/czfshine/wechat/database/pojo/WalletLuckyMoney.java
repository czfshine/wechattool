package cn.czfshine.wechat.database.pojo;


public class WalletLuckyMoney {

  private String mNativeUrl;
  private long hbType;
  private String receiveAmount;
  private String receiveTime;
  private long receiveStatus;
  private long hbStatus;


  public String getMNativeUrl() {
    return mNativeUrl;
  }

  public void setMNativeUrl(String mNativeUrl) {
    this.mNativeUrl = mNativeUrl;
  }


  public long getHbType() {
    return hbType;
  }

  public void setHbType(long hbType) {
    this.hbType = hbType;
  }


  public String getReceiveAmount() {
    return receiveAmount;
  }

  public void setReceiveAmount(String receiveAmount) {
    this.receiveAmount = receiveAmount;
  }


  public String getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(String receiveTime) {
    this.receiveTime = receiveTime;
  }


  public long getReceiveStatus() {
    return receiveStatus;
  }

  public void setReceiveStatus(long receiveStatus) {
    this.receiveStatus = receiveStatus;
  }


  public long getHbStatus() {
    return hbStatus;
  }

  public void setHbStatus(long hbStatus) {
    this.hbStatus = hbStatus;
  }

}
