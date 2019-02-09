package cn.czfshine.wechat.database.pojo;


public class BackupMoveTime {

  private String deviceId;
  private String sessionName;
  private String moveTime;


  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public String getSessionName() {
    return sessionName;
  }

  public void setSessionName(String sessionName) {
    this.sessionName = sessionName;
  }


  public String getMoveTime() {
    return moveTime;
  }

  public void setMoveTime(String moveTime) {
    this.moveTime = moveTime;
  }

}
