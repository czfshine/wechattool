package cn.czfshine.wechat.database.pojo;


public class ProfileInfo {

  private String username;
  private long originalArticleCount;
  private long friendSubscribeCount;
  private String allArticleWording;
  private String historyArticlesUrl;
  private long userRole;
  private String banReason;
  private long showRecommendArticle;
  private long showService;
  private String messageListStr;
  private String serviceInfoListStr;
  private String bizAccountListStr;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getOriginalArticleCount() {
    return originalArticleCount;
  }

  public void setOriginalArticleCount(long originalArticleCount) {
    this.originalArticleCount = originalArticleCount;
  }


  public long getFriendSubscribeCount() {
    return friendSubscribeCount;
  }

  public void setFriendSubscribeCount(long friendSubscribeCount) {
    this.friendSubscribeCount = friendSubscribeCount;
  }


  public String getAllArticleWording() {
    return allArticleWording;
  }

  public void setAllArticleWording(String allArticleWording) {
    this.allArticleWording = allArticleWording;
  }


  public String getHistoryArticlesUrl() {
    return historyArticlesUrl;
  }

  public void setHistoryArticlesUrl(String historyArticlesUrl) {
    this.historyArticlesUrl = historyArticlesUrl;
  }


  public long getUserRole() {
    return userRole;
  }

  public void setUserRole(long userRole) {
    this.userRole = userRole;
  }


  public String getBanReason() {
    return banReason;
  }

  public void setBanReason(String banReason) {
    this.banReason = banReason;
  }


  public long getShowRecommendArticle() {
    return showRecommendArticle;
  }

  public void setShowRecommendArticle(long showRecommendArticle) {
    this.showRecommendArticle = showRecommendArticle;
  }


  public long getShowService() {
    return showService;
  }

  public void setShowService(long showService) {
    this.showService = showService;
  }


  public String getMessageListStr() {
    return messageListStr;
  }

  public void setMessageListStr(String messageListStr) {
    this.messageListStr = messageListStr;
  }


  public String getServiceInfoListStr() {
    return serviceInfoListStr;
  }

  public void setServiceInfoListStr(String serviceInfoListStr) {
    this.serviceInfoListStr = serviceInfoListStr;
  }


  public String getBizAccountListStr() {
    return bizAccountListStr;
  }

  public void setBizAccountListStr(String bizAccountListStr) {
    this.bizAccountListStr = bizAccountListStr;
  }

}
