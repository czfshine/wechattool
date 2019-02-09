package cn.czfshine.wechat.database.pojo;


public class ImgInfo {

  private long id;
  private String msgSvrId;
  private long offset;
  private long totalLen;
  private String bigImgPath;
  private String thumbImgPath;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMsgSvrId() {
    return msgSvrId;
  }

  public void setMsgSvrId(String msgSvrId) {
    this.msgSvrId = msgSvrId;
  }


  public long getOffset() {
    return offset;
  }

  public void setOffset(long offset) {
    this.offset = offset;
  }


  public long getTotalLen() {
    return totalLen;
  }

  public void setTotalLen(long totalLen) {
    this.totalLen = totalLen;
  }


  public String getBigImgPath() {
    return bigImgPath;
  }

  public void setBigImgPath(String bigImgPath) {
    this.bigImgPath = bigImgPath;
  }


  public String getThumbImgPath() {
    return thumbImgPath;
  }

  public void setThumbImgPath(String thumbImgPath) {
    this.thumbImgPath = thumbImgPath;
  }

}
