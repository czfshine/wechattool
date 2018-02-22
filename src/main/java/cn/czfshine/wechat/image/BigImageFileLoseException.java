package cn.czfshine.wechat.image;

/**
 * @author:czfshine
 * @date:2018/2/22 22:18
 */

public class BigImageFileLoseException extends Exception {

    private BigImage bigImage;
    BigImageFileLoseException(BigImage bigImage){
        this.bigImage=bigImage;
    }
    public  String getFilename(){
        return bigImage.getFilename();
    }
}
