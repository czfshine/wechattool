package cn.czfshine.wechat.database.pojo;


public class WebViewHistory {

  private String recordId;
  private String link;
  private String title;
  private String source;
  private String imgUrl;
  private String timeStamp;


  public String getRecordId() {
    return recordId;
  }

  public void setRecordId(String recordId) {
    this.recordId = recordId;
  }


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

}
