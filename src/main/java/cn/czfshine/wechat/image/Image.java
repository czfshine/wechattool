package cn.czfshine.wechat.image;

/**
 * 图片对象，包括预览图，原图等信息
 * @author:czfshine
 * @date:2018/2/22 22:27
 */

public class Image {
    public String getMd5() {
        return md5;
    }

    public Image() {
    }

    public Image(String md5, String path) {
        this.md5 = md5;
        this.path = path;
    }

    protected String md5;

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    private String path;
}
