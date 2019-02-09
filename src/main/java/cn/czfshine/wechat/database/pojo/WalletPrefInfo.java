package cn.czfshine.wechat.database.pojo;


public class WalletPrefInfo {

  private String prefKey;
  private String prefTitle;
  private String prefUrl;
  private long isShow;


  public String getPrefKey() {
    return prefKey;
  }

  public void setPrefKey(String prefKey) {
    this.prefKey = prefKey;
  }


  public String getPrefTitle() {
    return prefTitle;
  }

  public void setPrefTitle(String prefTitle) {
    this.prefTitle = prefTitle;
  }


  public String getPrefUrl() {
    return prefUrl;
  }

  public void setPrefUrl(String prefUrl) {
    this.prefUrl = prefUrl;
  }


  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }

}
