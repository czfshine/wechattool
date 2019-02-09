package cn.czfshine.wechat.database.pojo;


public class SightDraftInfo {

  private long localId;
  private String fileName;
  private long fileNameHash;
  private String fileMd5;
  private String fileLength;
  private long fileStatus;
  private long fileDuration;
  private String createTime;


  public long getLocalId() {
    return localId;
  }

  public void setLocalId(long localId) {
    this.localId = localId;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public long getFileNameHash() {
    return fileNameHash;
  }

  public void setFileNameHash(long fileNameHash) {
    this.fileNameHash = fileNameHash;
  }


  public String getFileMd5() {
    return fileMd5;
  }

  public void setFileMd5(String fileMd5) {
    this.fileMd5 = fileMd5;
  }


  public String getFileLength() {
    return fileLength;
  }

  public void setFileLength(String fileLength) {
    this.fileLength = fileLength;
  }


  public long getFileStatus() {
    return fileStatus;
  }

  public void setFileStatus(long fileStatus) {
    this.fileStatus = fileStatus;
  }


  public long getFileDuration() {
    return fileDuration;
  }

  public void setFileDuration(long fileDuration) {
    this.fileDuration = fileDuration;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

}
