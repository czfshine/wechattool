package cn.czfshine.wechat.database.pojo;


public class FreeWifiInfo {

  private String ssidmd5;
  private String ssid;
  private String mid;
  private String url;
  private long connectState;
  private String expiredTime;
  private long wifiType;
  private long action;
  private String showUrl;
  private String showWordEn;
  private String showWordCn;
  private String showWordTw;
  private String mac;
  private long verifyResult;


  public String getSsidmd5() {
    return ssidmd5;
  }

  public void setSsidmd5(String ssidmd5) {
    this.ssidmd5 = ssidmd5;
  }


  public String getSsid() {
    return ssid;
  }

  public void setSsid(String ssid) {
    this.ssid = ssid;
  }


  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public long getConnectState() {
    return connectState;
  }

  public void setConnectState(long connectState) {
    this.connectState = connectState;
  }


  public String getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(String expiredTime) {
    this.expiredTime = expiredTime;
  }


  public long getWifiType() {
    return wifiType;
  }

  public void setWifiType(long wifiType) {
    this.wifiType = wifiType;
  }


  public long getAction() {
    return action;
  }

  public void setAction(long action) {
    this.action = action;
  }


  public String getShowUrl() {
    return showUrl;
  }

  public void setShowUrl(String showUrl) {
    this.showUrl = showUrl;
  }


  public String getShowWordEn() {
    return showWordEn;
  }

  public void setShowWordEn(String showWordEn) {
    this.showWordEn = showWordEn;
  }


  public String getShowWordCn() {
    return showWordCn;
  }

  public void setShowWordCn(String showWordCn) {
    this.showWordCn = showWordCn;
  }


  public String getShowWordTw() {
    return showWordTw;
  }

  public void setShowWordTw(String showWordTw) {
    this.showWordTw = showWordTw;
  }


  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }


  public long getVerifyResult() {
    return verifyResult;
  }

  public void setVerifyResult(long verifyResult) {
    this.verifyResult = verifyResult;
  }

}
