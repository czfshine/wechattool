package cn.czfshine.wechat.database.pojo;


public class CardQrCodeConfi {

  private String cardId;
  private long lowerBound;
  private long needInsertShowTimestamp;
  private String showTimestampEncryptKey;
  private long expireTimeInterval;
  private long showExpireInterval;
  private String fetchTime;


  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }


  public long getLowerBound() {
    return lowerBound;
  }

  public void setLowerBound(long lowerBound) {
    this.lowerBound = lowerBound;
  }


  public long getNeedInsertShowTimestamp() {
    return needInsertShowTimestamp;
  }

  public void setNeedInsertShowTimestamp(long needInsertShowTimestamp) {
    this.needInsertShowTimestamp = needInsertShowTimestamp;
  }


  public String getShowTimestampEncryptKey() {
    return showTimestampEncryptKey;
  }

  public void setShowTimestampEncryptKey(String showTimestampEncryptKey) {
    this.showTimestampEncryptKey = showTimestampEncryptKey;
  }


  public long getExpireTimeInterval() {
    return expireTimeInterval;
  }

  public void setExpireTimeInterval(long expireTimeInterval) {
    this.expireTimeInterval = expireTimeInterval;
  }


  public long getShowExpireInterval() {
    return showExpireInterval;
  }

  public void setShowExpireInterval(long showExpireInterval) {
    this.showExpireInterval = showExpireInterval;
  }


  public String getFetchTime() {
    return fetchTime;
  }

  public void setFetchTime(String fetchTime) {
    this.fetchTime = fetchTime;
  }

}
