package cn.czfshine.wechat.database.pojo;


public class IpCallAddressItem {

  private String wechatUsername;
  private String systemAddressBookUsername;
  private String contactId;
  private String sortKey;


  public String getWechatUsername() {
    return wechatUsername;
  }

  public void setWechatUsername(String wechatUsername) {
    this.wechatUsername = wechatUsername;
  }


  public String getSystemAddressBookUsername() {
    return systemAddressBookUsername;
  }

  public void setSystemAddressBookUsername(String systemAddressBookUsername) {
    this.systemAddressBookUsername = systemAddressBookUsername;
  }


  public String getContactId() {
    return contactId;
  }

  public void setContactId(String contactId) {
    this.contactId = contactId;
  }


  public String getSortKey() {
    return sortKey;
  }

  public void setSortKey(String sortKey) {
    this.sortKey = sortKey;
  }

}
