package cn.czfshine.wechat.database.pojo;


public class Tmessage {

  private long msgId;
  private long msgSvrId;
  private long type;
  private long status;
  private long isSend;
  private long isShowTimer;
  private long createTime;
  private String talker;
  private String content;
  private String imgPath;
  private String reserved;
  private String lvbuffer;
  private String transContent;
  private String transBrandWording;
  private long talkerId;
  private String bizClientMsgId;
  private long bizChatId;
  private String bizChatUserId;
  private long msgSeq;
  private long flag;


  public long getMsgId() {
    return msgId;
  }

  public void setMsgId(long msgId) {
    this.msgId = msgId;
  }


  public long getMsgSvrId() {
    return msgSvrId;
  }

  public void setMsgSvrId(long msgSvrId) {
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


  public long getIsSend() {
    return isSend;
  }

  public void setIsSend(long isSend) {
    this.isSend = isSend;
  }


  public long getIsShowTimer() {
    return isShowTimer;
  }

  public void setIsShowTimer(long isShowTimer) {
    this.isShowTimer = isShowTimer;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
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


  public String getReserved() {
    return reserved;
  }

  public void setReserved(String reserved) {
    this.reserved = reserved;
  }


  public String getLvbuffer() {
    return lvbuffer;
  }

  public void setLvbuffer(String lvbuffer) {
    this.lvbuffer = lvbuffer;
  }


  public String getTransContent() {
    return transContent;
  }

  public void setTransContent(String transContent) {
    this.transContent = transContent;
  }


  public String getTransBrandWording() {
    return transBrandWording;
  }

  public void setTransBrandWording(String transBrandWording) {
    this.transBrandWording = transBrandWording;
  }


  public long getTalkerId() {
    return talkerId;
  }

  public void setTalkerId(long talkerId) {
    this.talkerId = talkerId;
  }


  public String getBizClientMsgId() {
    return bizClientMsgId;
  }

  public void setBizClientMsgId(String bizClientMsgId) {
    this.bizClientMsgId = bizClientMsgId;
  }


  public long getBizChatId() {
    return bizChatId;
  }

  public void setBizChatId(long bizChatId) {
    this.bizChatId = bizChatId;
  }


  public String getBizChatUserId() {
    return bizChatUserId;
  }

  public void setBizChatUserId(String bizChatUserId) {
    this.bizChatUserId = bizChatUserId;
  }


  public long getMsgSeq() {
    return msgSeq;
  }

  public void setMsgSeq(long msgSeq) {
    this.msgSeq = msgSeq;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }

}
