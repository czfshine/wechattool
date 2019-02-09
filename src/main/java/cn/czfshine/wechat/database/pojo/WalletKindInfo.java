package cn.czfshine.wechat.database.pojo;


public class WalletKindInfo {

  private String walletTpaCountry;
  private long walletType;
  private String walletName;
  private long walletSelected;
  private long walletBalance;
  private long walletTpaCountryMask;


  public String getWalletTpaCountry() {
    return walletTpaCountry;
  }

  public void setWalletTpaCountry(String walletTpaCountry) {
    this.walletTpaCountry = walletTpaCountry;
  }


  public long getWalletType() {
    return walletType;
  }

  public void setWalletType(long walletType) {
    this.walletType = walletType;
  }


  public String getWalletName() {
    return walletName;
  }

  public void setWalletName(String walletName) {
    this.walletName = walletName;
  }


  public long getWalletSelected() {
    return walletSelected;
  }

  public void setWalletSelected(long walletSelected) {
    this.walletSelected = walletSelected;
  }


  public long getWalletBalance() {
    return walletBalance;
  }

  public void setWalletBalance(long walletBalance) {
    this.walletBalance = walletBalance;
  }


  public long getWalletTpaCountryMask() {
    return walletTpaCountryMask;
  }

  public void setWalletTpaCountryMask(long walletTpaCountryMask) {
    this.walletTpaCountryMask = walletTpaCountryMask;
  }

}
