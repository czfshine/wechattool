package cn.czfshine.wechat.database.pojo;


public class EmotionRewardTipInfo {

  private String prodcutId;
  private long totalCount;
  private long continuCount;
  private long flag;
  private String modifyTime;
  private String showTipsTime;
  private String setFlagTime;


  public String getProdcutId() {
    return prodcutId;
  }

  public void setProdcutId(String prodcutId) {
    this.prodcutId = prodcutId;
  }


  public long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }


  public long getContinuCount() {
    return continuCount;
  }

  public void setContinuCount(long continuCount) {
    this.continuCount = continuCount;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }


  public String getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(String modifyTime) {
    this.modifyTime = modifyTime;
  }


  public String getShowTipsTime() {
    return showTipsTime;
  }

  public void setShowTipsTime(String showTipsTime) {
    this.showTipsTime = showTipsTime;
  }


  public String getSetFlagTime() {
    return setFlagTime;
  }

  public void setSetFlagTime(String setFlagTime) {
    this.setFlagTime = setFlagTime;
  }

}
