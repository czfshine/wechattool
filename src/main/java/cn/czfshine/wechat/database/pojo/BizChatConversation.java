package cn.czfshine.wechat.database.pojo;


public class BizChatConversation {

  private String bizChatId;
  private String brandUserName;
  private long unReadCount;
  private long newUnReadCount;
  private String lastMsgId;
  private String lastMsgTime;
  private String content;
  private String digest;
  private String digestUser;
  private long atCount;
  private String editingMsg;
  private long chatType;
  private long status;
  private long isSend;
  private String msgType;
  private long msgCount;
  private String flag;


  public String getBizChatId() {
    return bizChatId;
  }

  public void setBizChatId(String bizChatId) {
    this.bizChatId = bizChatId;
  }


  public String getBrandUserName() {
    return brandUserName;
  }

  public void setBrandUserName(String brandUserName) {
    this.brandUserName = brandUserName;
  }


  public long getUnReadCount() {
    return unReadCount;
  }

  public void setUnReadCount(long unReadCount) {
    this.unReadCount = unReadCount;
  }


  public long getNewUnReadCount() {
    return newUnReadCount;
  }

  public void setNewUnReadCount(long newUnReadCount) {
    this.newUnReadCount = newUnReadCount;
  }


  public String getLastMsgId() {
    return lastMsgId;
  }

  public void setLastMsgId(String lastMsgId) {
    this.lastMsgId = lastMsgId;
  }


  public String getLastMsgTime() {
    return lastMsgTime;
  }

  public void setLastMsgTime(String lastMsgTime) {
    this.lastMsgTime = lastMsgTime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }


  public String getDigestUser() {
    return digestUser;
  }

  public void setDigestUser(String digestUser) {
    this.digestUser = digestUser;
  }


  public long getAtCount() {
    return atCount;
  }

  public void setAtCount(long atCount) {
    this.atCount = atCount;
  }


  public String getEditingMsg() {
    return editingMsg;
  }

  public void setEditingMsg(String editingMsg) {
    this.editingMsg = editingMsg;
  }


  public long getChatType() {
    return chatType;
  }

  public void setChatType(long chatType) {
    this.chatType = chatType;
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


  public String getMsgType() {
    return msgType;
  }

  public void setMsgType(String msgType) {
    this.msgType = msgType;
  }


  public long getMsgCount() {
    return msgCount;
  }

  public void setMsgCount(long msgCount) {
    this.msgCount = msgCount;
  }


  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

}
