package cn.czfshine.wechat.database.pojo;


public class LoanEntryInfo {

  private String title;
  private String loanJumpUrl;
  private long redDotIndex;
  private long isShowEntry;
  private String tips;
  private long isOverdue;
  private String availableOtb;


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getLoanJumpUrl() {
    return loanJumpUrl;
  }

  public void setLoanJumpUrl(String loanJumpUrl) {
    this.loanJumpUrl = loanJumpUrl;
  }


  public long getRedDotIndex() {
    return redDotIndex;
  }

  public void setRedDotIndex(long redDotIndex) {
    this.redDotIndex = redDotIndex;
  }


  public long getIsShowEntry() {
    return isShowEntry;
  }

  public void setIsShowEntry(long isShowEntry) {
    this.isShowEntry = isShowEntry;
  }


  public String getTips() {
    return tips;
  }

  public void setTips(String tips) {
    this.tips = tips;
  }


  public long getIsOverdue() {
    return isOverdue;
  }

  public void setIsOverdue(long isOverdue) {
    this.isOverdue = isOverdue;
  }


  public String getAvailableOtb() {
    return availableOtb;
  }

  public void setAvailableOtb(String availableOtb) {
    this.availableOtb = availableOtb;
  }

}
