package cn.czfshine.wechat.database.pojo;


public class MediaDuplication {

  private String md5;
  private long size;
  private String path;
  private String createtime;
  private String remuxing;
  private long duration;
  private long status;


  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }


  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }


  public String getRemuxing() {
    return remuxing;
  }

  public void setRemuxing(String remuxing) {
    this.remuxing = remuxing;
  }


  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
