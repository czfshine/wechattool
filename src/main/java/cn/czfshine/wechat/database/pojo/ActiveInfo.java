package cn.czfshine.wechat.database.pojo;


public class ActiveInfo {

  private long key;
  private long mau;
  private long dau;
  private String useTime;


  public long getKey() {
    return key;
  }

  public void setKey(long key) {
    this.key = key;
  }


  public long getMau() {
    return mau;
  }

  public void setMau(long mau) {
    this.mau = mau;
  }


  public long getDau() {
    return dau;
  }

  public void setDau(long dau) {
    this.dau = dau;
  }


  public String getUseTime() {
    return useTime;
  }

  public void setUseTime(String useTime) {
    this.useTime = useTime;
  }

}
