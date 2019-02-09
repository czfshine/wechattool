package cn.czfshine.wechat.database.pojo;


public class PendingCardId {

  private String cardUserId;
  private long retryCount;


  public String getCardUserId() {
    return cardUserId;
  }

  public void setCardUserId(String cardUserId) {
    this.cardUserId = cardUserId;
  }


  public long getRetryCount() {
    return retryCount;
  }

  public void setRetryCount(long retryCount) {
    this.retryCount = retryCount;
  }

}
