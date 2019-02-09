package cn.czfshine.wechat.database.pojo;


public class CardQrCodeDataInfo {

  private String codeId;
  private String cardId;
  private String code;
  private long status;


  public String getCodeId() {
    return codeId;
  }

  public void setCodeId(String codeId) {
    this.codeId = codeId;
  }


  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
