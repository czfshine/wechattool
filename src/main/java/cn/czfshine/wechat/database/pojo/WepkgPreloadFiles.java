package cn.czfshine.wechat.database.pojo;


public class WepkgPreloadFiles {

  private String key;
  private String pkgId;
  private String version;
  private String filePath;
  private String rid;
  private String mimeType;
  private String md5;
  private String downloadUrl;
  private long size;
  private long downloadNetType;
  private long completeDownload;
  private String createTime;
  private long autoDownloadCount;
  private long fileDownloadCount;


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  public String getPkgId() {
    return pkgId;
  }

  public void setPkgId(String pkgId) {
    this.pkgId = pkgId;
  }


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


  public String getRid() {
    return rid;
  }

  public void setRid(String rid) {
    this.rid = rid;
  }


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }


  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }


  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }


  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }


  public long getDownloadNetType() {
    return downloadNetType;
  }

  public void setDownloadNetType(long downloadNetType) {
    this.downloadNetType = downloadNetType;
  }


  public long getCompleteDownload() {
    return completeDownload;
  }

  public void setCompleteDownload(long completeDownload) {
    this.completeDownload = completeDownload;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public long getAutoDownloadCount() {
    return autoDownloadCount;
  }

  public void setAutoDownloadCount(long autoDownloadCount) {
    this.autoDownloadCount = autoDownloadCount;
  }


  public long getFileDownloadCount() {
    return fileDownloadCount;
  }

  public void setFileDownloadCount(long fileDownloadCount) {
    this.fileDownloadCount = fileDownloadCount;
  }

}
