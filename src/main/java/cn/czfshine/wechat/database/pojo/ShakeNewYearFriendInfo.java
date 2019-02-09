package cn.czfshine.wechat.database.pojo;


public class ShakeNewYearFriendInfo {

  private String username;
  private long lastshaketime;
  private long isshowed;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getLastshaketime() {
    return lastshaketime;
  }

  public void setLastshaketime(long lastshaketime) {
    this.lastshaketime = lastshaketime;
  }


  public long getIsshowed() {
    return isshowed;
  }

  public void setIsshowed(long isshowed) {
    this.isshowed = isshowed;
  }

}
