package cn.czfshine.wechat.database.pojo;


public class ContactLabel {

  private long labelId;
  private String labelName;
  private String labelPyFull;
  private String labelPyShort;
  private String createTime;
  private long isTemporary;


  public long getLabelId() {
    return labelId;
  }

  public void setLabelId(long labelId) {
    this.labelId = labelId;
  }


  public String getLabelName() {
    return labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }


  public String getLabelPyFull() {
    return labelPyFull;
  }

  public void setLabelPyFull(String labelPyFull) {
    this.labelPyFull = labelPyFull;
  }


  public String getLabelPyShort() {
    return labelPyShort;
  }

  public void setLabelPyShort(String labelPyShort) {
    this.labelPyShort = labelPyShort;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public long getIsTemporary() {
    return isTemporary;
  }

  public void setIsTemporary(long isTemporary) {
    this.isTemporary = isTemporary;
  }

}
