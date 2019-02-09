package cn.czfshine.wechat.database.pojo;


public class SportStepItem {

  private long id;
  private String date;
  private long step;
  private String timestamp;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  public long getStep() {
    return step;
  }

  public void setStep(long step) {
    this.step = step;
  }


  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

}
