package cn.czfshine.wechat.database.pojo;


public class VideoHash {

  private long size;
  private String createTime;
  private String hash;
  private String cdnxml;
  private String orgpath;


  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }


  public String getCdnxml() {
    return cdnxml;
  }

  public void setCdnxml(String cdnxml) {
    this.cdnxml = cdnxml;
  }


  public String getOrgpath() {
    return orgpath;
  }

  public void setOrgpath(String orgpath) {
    this.orgpath = orgpath;
  }

}
