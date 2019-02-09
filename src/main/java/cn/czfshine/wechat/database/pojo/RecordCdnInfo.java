package cn.czfshine.wechat.database.pojo;


public class RecordCdnInfo {

  private long localId;
  private long recordLocalId;
  private String toUser;
  private String dataId;
  private String mediaId;
  private String path;
  private String cdnUrl;
  private String cdnKey;
  private long totalLen;
  private long isThumb;
  private long offset;
  private long type;
  private long fileType;
  private long status;
  private long errCode;
  private String tpdataurl;
  private String tpauthkey;
  private String tpaeskey;


  public long getLocalId() {
    return localId;
  }

  public void setLocalId(long localId) {
    this.localId = localId;
  }


  public long getRecordLocalId() {
    return recordLocalId;
  }

  public void setRecordLocalId(long recordLocalId) {
    this.recordLocalId = recordLocalId;
  }


  public String getToUser() {
    return toUser;
  }

  public void setToUser(String toUser) {
    this.toUser = toUser;
  }


  public String getDataId() {
    return dataId;
  }

  public void setDataId(String dataId) {
    this.dataId = dataId;
  }


  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  public String getCdnUrl() {
    return cdnUrl;
  }

  public void setCdnUrl(String cdnUrl) {
    this.cdnUrl = cdnUrl;
  }


  public String getCdnKey() {
    return cdnKey;
  }

  public void setCdnKey(String cdnKey) {
    this.cdnKey = cdnKey;
  }


  public long getTotalLen() {
    return totalLen;
  }

  public void setTotalLen(long totalLen) {
    this.totalLen = totalLen;
  }


  public long getIsThumb() {
    return isThumb;
  }

  public void setIsThumb(long isThumb) {
    this.isThumb = isThumb;
  }


  public long getOffset() {
    return offset;
  }

  public void setOffset(long offset) {
    this.offset = offset;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getFileType() {
    return fileType;
  }

  public void setFileType(long fileType) {
    this.fileType = fileType;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getErrCode() {
    return errCode;
  }

  public void setErrCode(long errCode) {
    this.errCode = errCode;
  }


  public String getTpdataurl() {
    return tpdataurl;
  }

  public void setTpdataurl(String tpdataurl) {
    this.tpdataurl = tpdataurl;
  }


  public String getTpauthkey() {
    return tpauthkey;
  }

  public void setTpauthkey(String tpauthkey) {
    this.tpauthkey = tpauthkey;
  }


  public String getTpaeskey() {
    return tpaeskey;
  }

  public void setTpaeskey(String tpaeskey) {
    this.tpaeskey = tpaeskey;
  }

}
