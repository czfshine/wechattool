package cn.czfshine.wechat.database.pojo;


public class WalletFunciontList {

  private long walletRegion;
  private String functionList;
  private String newList;
  private String bannerList;
  private String typeNameList;


  public long getWalletRegion() {
    return walletRegion;
  }

  public void setWalletRegion(long walletRegion) {
    this.walletRegion = walletRegion;
  }


  public String getFunctionList() {
    return functionList;
  }

  public void setFunctionList(String functionList) {
    this.functionList = functionList;
  }


  public String getNewList() {
    return newList;
  }

  public void setNewList(String newList) {
    this.newList = newList;
  }


  public String getBannerList() {
    return bannerList;
  }

  public void setBannerList(String bannerList) {
    this.bannerList = bannerList;
  }


  public String getTypeNameList() {
    return typeNameList;
  }

  public void setTypeNameList(String typeNameList) {
    this.typeNameList = typeNameList;
  }

}
