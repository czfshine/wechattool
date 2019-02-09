package cn.czfshine.wechat.database.pojo;


public class WebViewResourceCache {

  private long urlMd5Hashcode;
  private String url;
  private String appId;
  private String domain;
  private String version;
  private String localPath;
  private String contentType;
  private String contentLength;
  private long isLatestVersion;
  private String createTime;
  private String accessTime;
  private String expireTime;
  private long cacheType;
  private String configId;
  private long protocol;
  private String packageId;
  private String contentMd5;


  public long getUrlMd5Hashcode() {
    return urlMd5Hashcode;
  }

  public void setUrlMd5Hashcode(long urlMd5Hashcode) {
    this.urlMd5Hashcode = urlMd5Hashcode;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }


  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  public String getLocalPath() {
    return localPath;
  }

  public void setLocalPath(String localPath) {
    this.localPath = localPath;
  }


  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }


  public String getContentLength() {
    return contentLength;
  }

  public void setContentLength(String contentLength) {
    this.contentLength = contentLength;
  }


  public long getIsLatestVersion() {
    return isLatestVersion;
  }

  public void setIsLatestVersion(long isLatestVersion) {
    this.isLatestVersion = isLatestVersion;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getAccessTime() {
    return accessTime;
  }

  public void setAccessTime(String accessTime) {
    this.accessTime = accessTime;
  }


  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }


  public long getCacheType() {
    return cacheType;
  }

  public void setCacheType(long cacheType) {
    this.cacheType = cacheType;
  }


  public String getConfigId() {
    return configId;
  }

  public void setConfigId(String configId) {
    this.configId = configId;
  }


  public long getProtocol() {
    return protocol;
  }

  public void setProtocol(long protocol) {
    this.protocol = protocol;
  }


  public String getPackageId() {
    return packageId;
  }

  public void setPackageId(String packageId) {
    this.packageId = packageId;
  }


  public String getContentMd5() {
    return contentMd5;
  }

  public void setContentMd5(String contentMd5) {
    this.contentMd5 = contentMd5;
  }

}
