package cn.czfshine.wechat.database.pojo;


public class ScanHistoryItem {

  private String productId;
  private String xmlContent;
  private String scanTime;
  private long funcType;
  private String qrcodeUrl;
  private long scene;


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  public String getXmlContent() {
    return xmlContent;
  }

  public void setXmlContent(String xmlContent) {
    this.xmlContent = xmlContent;
  }


  public String getScanTime() {
    return scanTime;
  }

  public void setScanTime(String scanTime) {
    this.scanTime = scanTime;
  }


  public long getFuncType() {
    return funcType;
  }

  public void setFuncType(long funcType) {
    this.funcType = funcType;
  }


  public String getQrcodeUrl() {
    return qrcodeUrl;
  }

  public void setQrcodeUrl(String qrcodeUrl) {
    this.qrcodeUrl = qrcodeUrl;
  }


  public long getScene() {
    return scene;
  }

  public void setScene(long scene) {
    this.scene = scene;
  }

}
