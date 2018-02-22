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



    private String filename;

    public String getFilename() {
        return filename;
    }


    
}
