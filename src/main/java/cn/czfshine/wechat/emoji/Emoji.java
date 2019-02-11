package cn.czfshine.wechat.emoji;

/**
 * 表情对象
 */
public class Emoji {

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getAnimationImage() {
        return animationImage;
    }

    public void setAnimationImage(String animationImage) {
        this.animationImage = animationImage;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public boolean isCustomized() {
        return customized;
    }

    public void setCustomized(boolean customized) {
        this.customized = customized;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    private String thumbImage; //1.静态表情的对应图片路径 2.动态表情的静态预览图
    private String animationImage;//动态表情对应的gif文件(不一定有)
    private boolean animated;//是否为动画表情
    private boolean customized;//是否是自定义表情

    private String desc;
    private String downloadUrl;//下载的url
}
