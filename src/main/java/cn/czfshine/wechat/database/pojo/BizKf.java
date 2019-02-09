package cn.czfshine.wechat.database.pojo;


public class BizKf {

  private String openId;
  private String brandUsername;
  private String headImgUrl;
  private String nickname;
  private long kfType;
  private String updateTime;


  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }


  public String getBrandUsername() {
    return brandUsername;
  }

  public void setBrandUsername(String brandUsername) {
    this.brandUsername = brandUsername;
  }


  public String getHeadImgUrl() {
    return headImgUrl;
  }

  public void setHeadImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public long getKfType() {
    return kfType;
  }

  public void setKfType(long kfType) {
    this.kfType = kfType;
  }


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
