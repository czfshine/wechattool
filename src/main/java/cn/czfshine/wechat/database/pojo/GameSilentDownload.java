package cn.czfshine.wechat.database.pojo;


public class GameSilentDownload {

  private String appId;
  private String downloadUrl;
  private String size;
  private String md5;
  private String packageName;
  private String expireTime;
  private String randomTime;
  private long isFirst;
  private String nextCheckTime;
  private long isRunning;
  private long noWifi;
  private long noSdcard;
  private long noEnoughSpace;
  private long lowBattery;
  private long continueDelay;


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }


  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }


  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }


  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }


  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }


  public String getRandomTime() {
    return randomTime;
  }

  public void setRandomTime(String randomTime) {
    this.randomTime = randomTime;
  }


  public long getIsFirst() {
    return isFirst;
  }

  public void setIsFirst(long isFirst) {
    this.isFirst = isFirst;
  }


  public String getNextCheckTime() {
    return nextCheckTime;
  }

  public void setNextCheckTime(String nextCheckTime) {
    this.nextCheckTime = nextCheckTime;
  }


  public long getIsRunning() {
    return isRunning;
  }

  public void setIsRunning(long isRunning) {
    this.isRunning = isRunning;
  }


  public long getNoWifi() {
    return noWifi;
  }

  public void setNoWifi(long noWifi) {
    this.noWifi = noWifi;
  }


  public long getNoSdcard() {
    return noSdcard;
  }

  public void setNoSdcard(long noSdcard) {
    this.noSdcard = noSdcard;
  }


  public long getNoEnoughSpace() {
    return noEnoughSpace;
  }

  public void setNoEnoughSpace(long noEnoughSpace) {
    this.noEnoughSpace = noEnoughSpace;
  }


  public long getLowBattery() {
    return lowBattery;
  }

  public void setLowBattery(long lowBattery) {
    this.lowBattery = lowBattery;
  }


  public long getContinueDelay() {
    return continueDelay;
  }

  public void setContinueDelay(long continueDelay) {
    this.continueDelay = continueDelay;
  }

}
