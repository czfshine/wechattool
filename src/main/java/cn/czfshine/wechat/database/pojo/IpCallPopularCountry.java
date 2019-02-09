package cn.czfshine.wechat.database.pojo;


public class IpCallPopularCountry {

  private long countryCode;
  private String callTimeCount;
  private String lastCallTime;


  public long getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(long countryCode) {
    this.countryCode = countryCode;
  }


  public String getCallTimeCount() {
    return callTimeCount;
  }

  public void setCallTimeCount(String callTimeCount) {
    this.callTimeCount = callTimeCount;
  }


  public String getLastCallTime() {
    return lastCallTime;
  }

  public void setLastCallTime(String lastCallTime) {
    this.lastCallTime = lastCallTime;
  }

}
