package cn.czfshine.wechat.database.pojo;


public class Contact {

  private long contactId;
  private long sex;
  private long type;
  private long showHead;
  private String username;
  private String nickname;
  private String pyInitial;
  private String quanPin;
  private String reserved;


  public long getContactId() {
    return contactId;
  }

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getShowHead() {
    return showHead;
  }

  public void setShowHead(long showHead) {
    this.showHead = showHead;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getPyInitial() {
    return pyInitial;
  }

  public void setPyInitial(String pyInitial) {
    this.pyInitial = pyInitial;
  }


  public String getQuanPin() {
    return quanPin;
  }

  public void setQuanPin(String quanPin) {
    this.quanPin = quanPin;
  }


  public String getReserved() {
    return reserved;
  }

  public void setReserved(String reserved) {
    this.reserved = reserved;
  }

}
