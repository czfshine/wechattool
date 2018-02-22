package cn.czfshine.wechat.image;

/**
 * @author:czfshine
 * @date:2018/2/22 21:29
 */

public class BigImage extends Image {

    public BigImage(Long msgid, String filename) {
        this.filename = filename;
        this.msgid=msgid;
    }
    private Long msgid;

    public String getMd5() {
        return md5;
    }

    private String md5;

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    private String path;
    
}
