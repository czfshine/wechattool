package cn.czfshine.wechat.database.pojo;


public class AddContactAntispamTicket {

  private String userName;
  private long scene;
  private String ticket;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public long getScene() {
    return scene;
  }

  public void setScene(long scene) {
    this.scene = scene;
  }


  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

}
