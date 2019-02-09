package cn.czfshine.wechat.database.pojo;


public class BizTimeLineInfo {

  private String msgId;
  private String msgSvrId;
  private long type;
  private long status;
  private String createTime;
  private String talker;
  private String content;
  private String imgPath;
  private String lvbuffer;
  private long talkerId;
  private long isExpand;
  private String orderFlag;
  private long hasShow;


  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }


  public String getMsgSvrId() {
    return msgSvrId;
  }

  public void setMsgSvrId(String msgSvrId) {
    this.msgSvrId = msgSvrId;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getTalker() {
    return talker;
  }

  public void setTalker(String talker) {
    this.talker = talker;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }


  public String getLvbuffer() {
    return lvbuffer;
  }

  public void setLvbuffer(String lvbuffer) {
    this.lvbuffer = lvbuffer;
  }


  public long getTalkerId() {
    return talkerId;
  }

  public void setTalkerId(long talkerId) {
    this.talkerId = talkerId;
  }


  public long getIsExpand() {
    return isExpand;
  }

  public void setIsExpand(long isExpand) {
    this.isExpand = isExpand;
  }


  public String getOrderFlag() {
    return orderFlag;
  }

  public void setOrderFlag(String orderFlag) {
    this.orderFlag = orderFlag;
  }


  public long getHasShow() {
    return hasShow;
  }

  public void setHasShow(long hasShow) {
    this.hasShow = hasShow;
  }

}
