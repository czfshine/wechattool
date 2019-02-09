package cn.czfshine.wechat.database.pojo;


public class HardDeviceRankInfo {

  private String rankId;
  private String appusername;
  private String username;
  private long ranknum;
  private long score;
  private long likecount;
  private long selfLikeState;


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


  public long getRanknum() {
    return ranknum;
  }

  public void setRanknum(long ranknum) {
    this.ranknum = ranknum;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }


  public long getLikecount() {
    return likecount;
  }

  public void setLikecount(long likecount) {
    this.likecount = likecount;
  }


  public long getSelfLikeState() {
    return selfLikeState;
  }

  public void setSelfLikeState(long selfLikeState) {
    this.selfLikeState = selfLikeState;
  }

}
