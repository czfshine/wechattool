package cn.czfshine.wechat.image;

/**
 * 高清图片(原图)
 * @author:czfshine
 * @date:2018/2/22 21:29
 */

public class BigImage extends Image {


    private Long msgid;

    private String filename;


    public BigImage(Long msgid, String filename) {

        this.filename = filename;
        this.msgid=msgid;
    }

    public String getFilename() {
        return filename;
    }
    
}
