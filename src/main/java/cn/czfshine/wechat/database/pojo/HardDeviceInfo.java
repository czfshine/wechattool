package cn.czfshine.wechat.database.pojo;


public class HardDeviceInfo {

  private String deviceId;
  private String brandName;
  private String mac;
  private String deviceType;
  private String connProto;
  private long connStrategy;
  private long closeStrategy;
  private String md5Str;
  private String authKey;
  private String url;
  private String sessionKey;
  private String sessionBuf;
  private String authBuf;
  private String lvbuffer;


  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }


  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }


  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }


  public String getConnProto() {
    return connProto;
  }

  public void setConnProto(String connProto) {
    this.connProto = connProto;
  }


  public long getConnStrategy() {
    return connStrategy;
  }

  public void setConnStrategy(long connStrategy) {
    this.connStrategy = connStrategy;
  }


  public long getCloseStrategy() {
    return closeStrategy;
  }

  public void setCloseStrategy(long closeStrategy) {
    this.closeStrategy = closeStrategy;
  }


  public String getMd5Str() {
    return md5Str;
  }

  public void setMd5Str(String md5Str) {
    this.md5Str = md5Str;
  }


  public String getAuthKey() {
    return authKey;
  }

  public void setAuthKey(String authKey) {
    this.authKey = authKey;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }


  public String getSessionBuf() {
    return sessionBuf;
  }

  public void setSessionBuf(String sessionBuf) {
    this.sessionBuf = sessionBuf;
  }


  public String getAuthBuf() {
    return authBuf;
  }

  public void setAuthBuf(String authBuf) {
    this.authBuf = authBuf;
  }


  public String getLvbuffer() {
    return lvbuffer;
  }

  public void setLvbuffer(String lvbuffer) {
    this.lvbuffer = lvbuffer;
  }

}
