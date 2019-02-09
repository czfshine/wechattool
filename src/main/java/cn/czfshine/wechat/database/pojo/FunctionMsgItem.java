package cn.czfshine.wechat.database.pojo;


public class FunctionMsgItem {

  private String cgi;
  private long cmdid;
  private String functionmsgid;
  private String version;
  private String preVersion;
  private long retryinterval;
  private long reportid;
  private long successkey;
  private long failkey;
  private long finalfailkey;
  private String custombuff;
  private String addMsg;
  private long status;
  private long needShow;


  public String getCgi() {
    return cgi;
  }

  public void setCgi(String cgi) {
    this.cgi = cgi;
  }


  public long getCmdid() {
    return cmdid;
  }

  public void setCmdid(long cmdid) {
    this.cmdid = cmdid;
  }


  public String getFunctionmsgid() {
    return functionmsgid;
  }

  public void setFunctionmsgid(String functionmsgid) {
    this.functionmsgid = functionmsgid;
  }


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  public String getPreVersion() {
    return preVersion;
  }

  public void setPreVersion(String preVersion) {
    this.preVersion = preVersion;
  }


  public long getRetryinterval() {
    return retryinterval;
  }

  public void setRetryinterval(long retryinterval) {
    this.retryinterval = retryinterval;
  }


  public long getReportid() {
    return reportid;
  }

  public void setReportid(long reportid) {
    this.reportid = reportid;
  }


  public long getSuccesskey() {
    return successkey;
  }

  public void setSuccesskey(long successkey) {
    this.successkey = successkey;
  }


  public long getFailkey() {
    return failkey;
  }

  public void setFailkey(long failkey) {
    this.failkey = failkey;
  }


  public long getFinalfailkey() {
    return finalfailkey;
  }

  public void setFinalfailkey(long finalfailkey) {
    this.finalfailkey = finalfailkey;
  }


  public String getCustombuff() {
    return custombuff;
  }

  public void setCustombuff(String custombuff) {
    this.custombuff = custombuff;
  }


  public String getAddMsg() {
    return addMsg;
  }

  public void setAddMsg(String addMsg) {
    this.addMsg = addMsg;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getNeedShow() {
    return needShow;
  }

  public void setNeedShow(long needShow) {
    this.needShow = needShow;
  }

}
