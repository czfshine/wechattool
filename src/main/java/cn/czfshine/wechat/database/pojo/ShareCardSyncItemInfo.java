package cn.czfshine.wechat.database.pojo;


public class ShareCardSyncItemInfo {

  private String cardId;
  private long stateFlag;
  private String updateTime;
  private String seq;
  private long retryCount;


  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }


  public long getStateFlag() {
    return stateFlag;
  }

  public void setStateFlag(long stateFlag) {
    this.stateFlag = stateFlag;
  }


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }


  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }


  public long getRetryCount() {
    return retryCount;
  }

  public void setRetryCount(long retryCount) {
    this.retryCount = retryCount;
  }

}
