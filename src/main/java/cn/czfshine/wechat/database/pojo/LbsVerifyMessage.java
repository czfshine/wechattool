package cn.czfshine.wechat.database.pojo;


public class LbsVerifyMessage {

  private String svrid;
  private long status;
  private long type;
  private long scene;
  private String createtime;
  private String talker;
  private String content;
  private String sayhiuser;
  private String sayhicontent;
  private String imgpath;
  private long isSend;
  private String sayhiencryptuser;
  private String ticket;
  private long flag;


  public String getSvrid() {
    return svrid;
  }

  public void setSvrid(String svrid) {
    this.svrid = svrid;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getScene() {
    return scene;
  }

  public void setScene(long scene) {
    this.scene = scene;
  }


  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }


  public String getTalker() {
    return talker;
  }

  public void setTalker(String talker) {
    this.talker = talker;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getSayhiuser() {
    return sayhiuser;
  }

  public void setSayhiuser(String sayhiuser) {
    this.sayhiuser = sayhiuser;
  }


  public String getSayhicontent() {
    return sayhicontent;
  }

  public void setSayhicontent(String sayhicontent) {
    this.sayhicontent = sayhicontent;
  }


  public String getImgpath() {
    return imgpath;
  }

  public void setImgpath(String imgpath) {
    this.imgpath = imgpath;
  }


  public long getIsSend() {
    return isSend;
  }

  public void setIsSend(long isSend) {
    this.isSend = isSend;
  }


  public String getSayhiencryptuser() {
    return sayhiencryptuser;
  }

  public void setSayhiencryptuser(String sayhiencryptuser) {
    this.sayhiencryptuser = sayhiencryptuser;
  }


  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }

}
