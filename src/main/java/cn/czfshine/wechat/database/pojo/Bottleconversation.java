package cn.czfshine.wechat.database.pojo;


public class Bottleconversation {

  private long unReadCount;
  private long status;
  private long isSend;
  private String createTime;
  private String username;
  private String content;
  private String reserved;


  public long getUnReadCount() {
    return unReadCount;
  }

  public void setUnReadCount(long unReadCount) {
    this.unReadCount = unReadCount;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getIsSend() {
    return isSend;
  }

  public void setIsSend(long isSend) {
    this.isSend = isSend;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getReserved() {
    return reserved;
  }

  public void setReserved(String reserved) {
    this.reserved = reserved;
  }

}
