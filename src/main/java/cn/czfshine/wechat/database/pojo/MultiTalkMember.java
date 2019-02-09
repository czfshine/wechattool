package cn.czfshine.wechat.database.pojo;


public class MultiTalkMember {

  private String memberUuid;
  private String wxGroupId;
  private String userName;
  private String inviteUserName;
  private String memberId;
  private long status;
  private String createTime;


  public String getMemberUuid() {
    return memberUuid;
  }

  public void setMemberUuid(String memberUuid) {
    this.memberUuid = memberUuid;
  }


  public String getWxGroupId() {
    return wxGroupId;
  }

  public void setWxGroupId(String wxGroupId) {
    this.wxGroupId = wxGroupId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getInviteUserName() {
    return inviteUserName;
  }

  public void setInviteUserName(String inviteUserName) {
    this.inviteUserName = inviteUserName;
  }


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
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

}
