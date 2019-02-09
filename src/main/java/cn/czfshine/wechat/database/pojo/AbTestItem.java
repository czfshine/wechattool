package cn.czfshine.wechat.database.pojo;


public class AbTestItem {

  private String layerId;
  private String business;
  private String expId;
  private String sequence;
  private long prioritylevel;
  private String startTime;
  private String endTime;
  private long needReport;
  private String rawXml;


  public String getLayerId() {
    return layerId;
  }

  public void setLayerId(String layerId) {
    this.layerId = layerId;
  }


  public String getBusiness() {
    return business;
  }

  public void setBusiness(String business) {
    this.business = business;
  }


  public String getExpId() {
    return expId;
  }

  public void setExpId(String expId) {
    this.expId = expId;
  }


  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }


  public long getPrioritylevel() {
    return prioritylevel;
  }

  public void setPrioritylevel(long prioritylevel) {
    this.prioritylevel = prioritylevel;
  }


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  public long getNeedReport() {
    return needReport;
  }

  public void setNeedReport(long needReport) {
    this.needReport = needReport;
  }


  public String getRawXml() {
    return rawXml;
  }

  public void setRawXml(String rawXml) {
    this.rawXml = rawXml;
  }

}
