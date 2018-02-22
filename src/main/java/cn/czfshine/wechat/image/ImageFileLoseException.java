package cn.czfshine.wechat.image;

/**
 * @author:czfshine
 * @date:2018/2/22 23:32
 */

public class ImageFileLoseException extends  Exception {
    public String getMd5() {
        return md5;
    }

    private String md5;

    public ImageFileLoseException(String md5) {
        this.md5 = md5;
    }
}
