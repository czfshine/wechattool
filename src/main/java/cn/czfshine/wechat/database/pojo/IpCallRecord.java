package cn.czfshine.wechat.database.pojo;


public class IpCallRecord {

  private String phonenumber;
  private String calltime;
  private String duration;
  private long status;
  private String addressId;
  private long phoneType;


  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


  public String getCalltime() {
    return calltime;
  }

  public void setCalltime(String calltime) {
    this.calltime = calltime;
  }


  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getAddressId() {
    return addressId;
  }

  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }


  public long getPhoneType() {
    return phoneType;
  }

  public void setPhoneType(long phoneType) {
    this.phoneType = phoneType;
  }

}
