package cn.czfshine.wechat.database.pojo;


public class HardDeviceLikeUser {

  private String rankId;
  private String appusername;
  private String username;
  private long timestamp;
  private String liketips;


  public String getRankId() {
    return rankId;
  }

  public void setRankId(String rankId) {
    this.rankId = rankId;
  }


  public String getAppusername() {
    return appusername;
  }

  public void setAppusername(String appusername) {
    this.appusername = appusername;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }


  public String getLiketips() {
    return liketips;
  }

  public void setLiketips(String liketips) {
    this.liketips = liketips;
  }

}
