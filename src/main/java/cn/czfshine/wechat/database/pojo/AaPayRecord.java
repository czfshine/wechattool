package cn.czfshine.wechat.database.pojo;


public class AaPayRecord {

  private String payMsgId;
  private long insertmsg;
  private String chatroom;
  private String msgId;


  public String getPayMsgId() {
    return payMsgId;
  }

  public void setPayMsgId(String payMsgId) {
    this.payMsgId = payMsgId;
  }


  public long getInsertmsg() {
    return insertmsg;
  }

  public void setInsertmsg(long insertmsg) {
    this.insertmsg = insertmsg;
  }


  public String getChatroom() {
    return chatroom;
  }

  public void setChatroom(String chatroom) {
    this.chatroom = chatroom;
  }


  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

}
