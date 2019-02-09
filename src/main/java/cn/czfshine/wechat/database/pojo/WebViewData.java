package cn.czfshine.wechat.database.pojo;


public class WebViewData {

  private String appId;
  private String appIdKey;
  private String value;
  private String weight;
  private String expireTime;
  private String timeStamp;
  private String size;


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getAppIdKey() {
    return appIdKey;
  }

  public void setAppIdKey(String appIdKey) {
    this.appIdKey = appIdKey;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }


  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }


  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }


  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

}
