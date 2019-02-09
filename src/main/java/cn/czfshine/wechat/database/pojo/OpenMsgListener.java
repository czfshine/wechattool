package cn.czfshine.wechat.database.pojo;


public class OpenMsgListener {

  private String appId;
  private String packageName;
  private long status;
  private long sceneFlag;
  private long msgTypeFlag;
  private long msgState;


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getSceneFlag() {
    return sceneFlag;
  }

  public void setSceneFlag(long sceneFlag) {
    this.sceneFlag = sceneFlag;
  }


  public long getMsgTypeFlag() {
    return msgTypeFlag;
  }

  public void setMsgTypeFlag(long msgTypeFlag) {
    this.msgTypeFlag = msgTypeFlag;
  }


  public long getMsgState() {
    return msgState;
  }

  public void setMsgState(long msgState) {
    this.msgState = msgState;
  }

}
