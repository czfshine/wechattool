package cn.czfshine.wechat.database.pojo;


public class WebViewCacheResConfigMap {

  private long disable;
  private String configId;
  private String configUrl;
  private String configResources;
  private String configCrc32;
  private long isFromXml;


  public long getDisable() {
    return disable;
  }

  public void setDisable(long disable) {
    this.disable = disable;
  }


  public String getConfigId() {
    return configId;
  }

  public void setConfigId(String configId) {
    this.configId = configId;
  }


  public String getConfigUrl() {
    return configUrl;
  }

  public void setConfigUrl(String configUrl) {
    this.configUrl = configUrl;
  }


  public String getConfigResources() {
    return configResources;
  }

  public void setConfigResources(String configResources) {
    this.configResources = configResources;
  }


  public String getConfigCrc32() {
    return configCrc32;
  }

  public void setConfigCrc32(String configCrc32) {
    this.configCrc32 = configCrc32;
  }


  public long getIsFromXml() {
    return isFromXml;
  }

  public void setIsFromXml(long isFromXml) {
    this.isFromXml = isFromXml;
  }

}
