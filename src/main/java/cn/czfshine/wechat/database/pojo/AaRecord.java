package cn.czfshine.wechat.database.pojo;


public class AaRecord {

  private String billNo;
  private long insertmsg;
  private String localMsgId;
  private long status;


  public String getBillNo() {
    return billNo;
  }

  public void setBillNo(String billNo) {
    this.billNo = billNo;
  }


  public long getInsertmsg() {
    return insertmsg;
  }

  public void setInsertmsg(long insertmsg) {
    this.insertmsg = insertmsg;
  }


  public String getLocalMsgId() {
    return localMsgId;
  }

  public void setLocalMsgId(String localMsgId) {
    this.localMsgId = localMsgId;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
