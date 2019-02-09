package cn.czfshine.wechat.database.pojo;


public class BizChatUserInfo {

  private String userId;
  private String userName;
  private String userNamePy;
  private String brandUserName;
  private long userVersion;
  private long needToUpdate;
  private String headImageUrl;
  private String profileUrl;
  private long bitFlag;
  private String addMemberUrl;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserNamePy() {
    return userNamePy;
  }

  public void setUserNamePy(String userNamePy) {
    this.userNamePy = userNamePy;
  }


  public String getBrandUserName() {
    return brandUserName;
  }

  public void setBrandUserName(String brandUserName) {
    this.brandUserName = brandUserName;
  }


  public long getUserVersion() {
    return userVersion;
  }

  public void setUserVersion(long userVersion) {
    this.userVersion = userVersion;
  }


  public long getNeedToUpdate() {
    return needToUpdate;
  }

  public void setNeedToUpdate(long needToUpdate) {
    this.needToUpdate = needToUpdate;
  }


  public String getHeadImageUrl() {
    return headImageUrl;
  }

  public void setHeadImageUrl(String headImageUrl) {
    this.headImageUrl = headImageUrl;
  }


  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
  }


  public long getBitFlag() {
    return bitFlag;
  }

  public void setBitFlag(long bitFlag) {
    this.bitFlag = bitFlag;
  }


  public String getAddMemberUrl() {
    return addMemberUrl;
  }

  public void setAddMemberUrl(String addMemberUrl) {
    this.addMemberUrl = addMemberUrl;
  }

}
