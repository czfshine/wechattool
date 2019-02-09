package cn.czfshine.wechat.database.pojo;


public class WebviewLocalData {

  private long recordId;
  private String appId;
  private String domin;
  private String key;
  private String value;


  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long recordId) {
    this.recordId = recordId;
  }


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getDomin() {
    return domin;
  }

  public void setDomin(String domin) {
    this.domin = domin;
  }


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
