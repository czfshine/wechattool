package cn.czfshine.wechat.database.pojo;


public class AbTestInfo {

  private String abtestkey;
  private String value;
  private String expId;
  private String sequence;
  private long prioritylevel;
  private String startTime;
  private String endTime;
  private long noReport;


  public String getAbtestkey() {
    return abtestkey;
  }

  public void setAbtestkey(String abtestkey) {
    this.abtestkey = abtestkey;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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


  public long getNoReport() {
    return noReport;
  }

  public void setNoReport(long noReport) {
    this.noReport = noReport;
  }

}
