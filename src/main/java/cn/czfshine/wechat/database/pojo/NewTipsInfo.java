package cn.czfshine.wechat.database.pojo;


public class NewTipsInfo {

  private long tipId;
  private long tipVersion;
  private String tipkey;
  private long tipType;
  private long isExit;
  private long hadRead;
  private long isReject;
  private String beginShowTime;
  private String disappearTime;
  private String overdueTime;
  private String tipsShowInfo;
  private String extInfo;
  private String pagestaytime;


  public long getTipId() {
    return tipId;
  }

  public void setTipId(long tipId) {
    this.tipId = tipId;
  }


  public long getTipVersion() {
    return tipVersion;
  }

  public void setTipVersion(long tipVersion) {
    this.tipVersion = tipVersion;
  }


  public String getTipkey() {
    return tipkey;
  }

  public void setTipkey(String tipkey) {
    this.tipkey = tipkey;
  }


  public long getTipType() {
    return tipType;
  }

  public void setTipType(long tipType) {
    this.tipType = tipType;
  }


  public long getIsExit() {
    return isExit;
  }

  public void setIsExit(long isExit) {
    this.isExit = isExit;
  }


  public long getHadRead() {
    return hadRead;
  }

  public void setHadRead(long hadRead) {
    this.hadRead = hadRead;
  }


  public long getIsReject() {
    return isReject;
  }

  public void setIsReject(long isReject) {
    this.isReject = isReject;
  }


  public String getBeginShowTime() {
    return beginShowTime;
  }

  public void setBeginShowTime(String beginShowTime) {
    this.beginShowTime = beginShowTime;
  }


  public String getDisappearTime() {
    return disappearTime;
  }

  public void setDisappearTime(String disappearTime) {
    this.disappearTime = disappearTime;
  }


  public String getOverdueTime() {
    return overdueTime;
  }

  public void setOverdueTime(String overdueTime) {
    this.overdueTime = overdueTime;
  }


  public String getTipsShowInfo() {
    return tipsShowInfo;
  }

  public void setTipsShowInfo(String tipsShowInfo) {
    this.tipsShowInfo = tipsShowInfo;
  }


  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
  }


  public String getPagestaytime() {
    return pagestaytime;
  }

  public void setPagestaytime(String pagestaytime) {
    this.pagestaytime = pagestaytime;
  }

}
