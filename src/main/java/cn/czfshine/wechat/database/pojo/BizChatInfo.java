package cn.czfshine.wechat.database.pojo;


public class BizChatInfo {

  private String bizChatLocalId;
  private String bizChatServId;
  private String brandUserName;
  private long chatType;
  private String headImageUrl;
  private String chatName;
  private String chatNamePy;
  private long chatVersion;
  private long needToUpdate;
  private long bitFlag;
  private long maxMemberCnt;
  private String ownerUserId;
  private String userList;
  private String addMemberUrl;


  public String getBizChatLocalId() {
    return bizChatLocalId;
  }

  public void setBizChatLocalId(String bizChatLocalId) {
    this.bizChatLocalId = bizChatLocalId;
  }


  public String getBizChatServId() {
    return bizChatServId;
  }

  public void setBizChatServId(String bizChatServId) {
    this.bizChatServId = bizChatServId;
  }


  public String getBrandUserName() {
    return brandUserName;
  }

  public void setBrandUserName(String brandUserName) {
    this.brandUserName = brandUserName;
  }


  public long getChatType() {
    return chatType;
  }

  public void setChatType(long chatType) {
    this.chatType = chatType;
  }


  public String getHeadImageUrl() {
    return headImageUrl;
  }

  public void setHeadImageUrl(String headImageUrl) {
    this.headImageUrl = headImageUrl;
  }


  public String getChatName() {
    return chatName;
  }

  public void setChatName(String chatName) {
    this.chatName = chatName;
  }


  public String getChatNamePy() {
    return chatNamePy;
  }

  public void setChatNamePy(String chatNamePy) {
    this.chatNamePy = chatNamePy;
  }


  public long getChatVersion() {
    return chatVersion;
  }

  public void setChatVersion(long chatVersion) {
    this.chatVersion = chatVersion;
  }


  public long getNeedToUpdate() {
    return needToUpdate;
  }

  public void setNeedToUpdate(long needToUpdate) {
    this.needToUpdate = needToUpdate;
  }


  public long getBitFlag() {
    return bitFlag;
  }

  public void setBitFlag(long bitFlag) {
    this.bitFlag = bitFlag;
  }


  public long getMaxMemberCnt() {
    return maxMemberCnt;
  }

  public void setMaxMemberCnt(long maxMemberCnt) {
    this.maxMemberCnt = maxMemberCnt;
  }


  public String getOwnerUserId() {
    return ownerUserId;
  }

  public void setOwnerUserId(String ownerUserId) {
    this.ownerUserId = ownerUserId;
  }


  public String getUserList() {
    return userList;
  }

  public void setUserList(String userList) {
    this.userList = userList;
  }


  public String getAddMemberUrl() {
    return addMemberUrl;
  }

  public void setAddMemberUrl(String addMemberUrl) {
    this.addMemberUrl = addMemberUrl;
  }

}
