package cn.czfshine.wechat.database.pojo;


public class TablesVersion {

  private long tableHash;
  private String tableSqlmd5;


  public long getTableHash() {
    return tableHash;
  }

  public void setTableHash(long tableHash) {
    this.tableHash = tableHash;
  }


  public String getTableSqlmd5() {
    return tableSqlmd5;
  }

  public void setTableSqlmd5(String tableSqlmd5) {
    this.tableSqlmd5 = tableSqlmd5;
  }

}
