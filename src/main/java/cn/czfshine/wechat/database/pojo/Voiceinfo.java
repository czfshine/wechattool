package cn.czfshine.wechat.database.pojo;


public class Voiceinfo {

  private String fileName;
  private String user;
  private long msgId;
  private long netOffset;
  private long fileNowSize;
  private long totalLen;
  private long status;
  private long createTime;
  private long lastModifyTime;
  private String clientId;
  private long voiceLength;
  private long msgLocalId;
  private String human;
  private long reserved1;
  private String reserved2;
  private String msgSource;
  private long msgFlag;
  private long msgSeq;
  private long masterBufId;
  private long checksum;


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }


  public long getMsgId() {
    return msgId;
  }

  public void setMsgId(long msgId) {
    this.msgId = msgId;
  }


  public long getNetOffset() {
    return netOffset;
  }

  public void setNetOffset(long netOffset) {
    this.netOffset = netOffset;
  }


  public long getFileNowSize() {
    return fileNowSize;
  }

  public void setFileNowSize(long fileNowSize) {
    this.fileNowSize = fileNowSize;
  }


  public long getTotalLen() {
    return totalLen;
  }

  public void setTotalLen(long totalLen) {
    this.totalLen = totalLen;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }


  public long getLastModifyTime() {
    return lastModifyTime;
  }

  public void setLastModifyTime(long lastModifyTime) {
    this.lastModifyTime = lastModifyTime;
  }


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }


  public long getVoiceLength() {
    return voiceLength;
  }

  public void setVoiceLength(long voiceLength) {
    this.voiceLength = voiceLength;
  }


  public long getMsgLocalId() {
    return msgLocalId;
  }

  public void setMsgLocalId(long msgLocalId) {
    this.msgLocalId = msgLocalId;
  }


  public String getHuman() {
    return human;
  }

  public void setHuman(String human) {
    this.human = human;
  }


  public long getReserved1() {
    return reserved1;
  }

  public void setReserved1(long reserved1) {
    this.reserved1 = reserved1;
  }


  public String getReserved2() {
    return reserved2;
  }

  public void setReserved2(String reserved2) {
    this.reserved2 = reserved2;
  }


  public String getMsgSource() {
    return msgSource;
  }

  public void setMsgSource(String msgSource) {
    this.msgSource = msgSource;
  }


  public long getMsgFlag() {
    return msgFlag;
  }

  public void setMsgFlag(long msgFlag) {
    this.msgFlag = msgFlag;
  }


  public long getMsgSeq() {
    return msgSeq;
  }

  public void setMsgSeq(long msgSeq) {
    this.msgSeq = msgSeq;
  }


  public long getMasterBufId() {
    return masterBufId;
  }

  public void setMasterBufId(long masterBufId) {
    this.masterBufId = masterBufId;
  }


  public long getChecksum() {
    return checksum;
  }

  public void setChecksum(long checksum) {
    this.checksum = checksum;
  }

}
