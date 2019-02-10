package cn.czfshine.wechat.image;

import java.io.Serializable;

/**
 * 图片对象，包括预览图，原图等信息
 * @author:czfshine
 * @date:2018/2/22 22:27
 */

public class Image implements Serializable {
    public  static final long serialVersionUID =1802252205;

    public String getThumbImgName() {
        return ThumbImgName;
    }

    public String getBigImgName() {
        return BigImgName;
    }

    public String getBigImgPath() {
        return BigImgPath;
    }

    public String getThumbImgPath() {
        return ThumbImgPath;
    }

    private String BigImgPath;

    public void setBigImgPath(String bigImgPath) {
        BigImgPath = bigImgPath;
    }

    public void setThumbImgPath(String thumbImgPath) {
        ThumbImgPath = thumbImgPath;
    }

    private String ThumbImgPath;

    private String ThumbImgName;
    private String BigImgName;

    public Image(String thumbImgName){
        this.ThumbImgName=thumbImgName;
    }

    public Image(String thumbImgName, String bigImgName) {
        ThumbImgName = thumbImgName;
        BigImgName = bigImgName;
    }
}
