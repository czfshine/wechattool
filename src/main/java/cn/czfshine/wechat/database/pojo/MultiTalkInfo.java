package cn.czfshine.wechat.database.pojo;


public class MultiTalkInfo {

  private String wxGroupId;
  private String groupId;
  private long roomId;
  private String roomKey;
  private long routeId;
  private String inviteUserName;
  private long memberCount;
  private String createTime;
  private long state;


  public String getWxGroupId() {
    return wxGroupId;
  }

  public void setWxGroupId(String wxGroupId) {
    this.wxGroupId = wxGroupId;
  }


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }


  public String getRoomKey() {
    return roomKey;
  }

  public void setRoomKey(String roomKey) {
    this.roomKey = roomKey;
  }


  public long getRouteId() {
    return routeId;
  }

  public void setRouteId(long routeId) {
    this.routeId = routeId;
  }


  public String getInviteUserName() {
    return inviteUserName;
  }

  public void setInviteUserName(String inviteUserName) {
    this.inviteUserName = inviteUserName;
  }


  public long getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(long memberCount) {
    this.memberCount = memberCount;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
