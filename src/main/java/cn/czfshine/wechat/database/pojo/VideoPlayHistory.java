package cn.czfshine.wechat.database.pojo;


public class VideoPlayHistory {

  private String filename;
  private long starttime;
  private long playduration;
  private long downloadway;


  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }


  public long getStarttime() {
    return starttime;
  }

  public void setStarttime(long starttime) {
    this.starttime = starttime;
  }


  public long getPlayduration() {
    return playduration;
  }

  public void setPlayduration(long playduration) {
    this.playduration = playduration;
  }


  public long getDownloadway() {
    return downloadway;
  }

  public void setDownloadway(long downloadway) {
    this.downloadway = downloadway;
  }

}
