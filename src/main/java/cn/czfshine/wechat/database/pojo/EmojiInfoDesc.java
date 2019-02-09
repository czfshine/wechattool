package cn.czfshine.wechat.database.pojo;


public class EmojiInfoDesc {

  private String md5Lang;
  private String md5;
  private String lang;
  private String desc;
  private String groupId;
  private long clickFlag;
  private long downloadFlag;


  public String getMd5Lang() {
    return md5Lang;
  }

  public void setMd5Lang(String md5Lang) {
    this.md5Lang = md5Lang;
  }


  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }


  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public long getClickFlag() {
    return clickFlag;
  }

  public void setClickFlag(long clickFlag) {
    this.clickFlag = clickFlag;
  }


  public long getDownloadFlag() {
    return downloadFlag;
  }

  public void setDownloadFlag(long downloadFlag) {
    this.downloadFlag = downloadFlag;
  }

}
