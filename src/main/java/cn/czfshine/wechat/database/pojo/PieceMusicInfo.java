package cn.czfshine.wechat.database.pojo;


public class PieceMusicInfo {

  private String musicId;
  private String musicUrl;
  private String fileName;
  private String indexBitData;
  private long fileCacheComplete;
  private String pieceFileMimeType;


  public String getMusicId() {
    return musicId;
  }

  public void setMusicId(String musicId) {
    this.musicId = musicId;
  }


  public String getMusicUrl() {
    return musicUrl;
  }

  public void setMusicUrl(String musicUrl) {
    this.musicUrl = musicUrl;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public String getIndexBitData() {
    return indexBitData;
  }

  public void setIndexBitData(String indexBitData) {
    this.indexBitData = indexBitData;
  }


  public long getFileCacheComplete() {
    return fileCacheComplete;
  }

  public void setFileCacheComplete(long fileCacheComplete) {
    this.fileCacheComplete = fileCacheComplete;
  }


  public String getPieceFileMimeType() {
    return pieceFileMimeType;
  }

  public void setPieceFileMimeType(String pieceFileMimeType) {
    this.pieceFileMimeType = pieceFileMimeType;
  }

}
