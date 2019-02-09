package cn.czfshine.wechat.resources;

import cn.czfshine.wechat.image.Image;
import cn.czfshine.wechat.msg.BaseMessage;

public class Resources  {

    /**增加资源目录到资源池
     * @param path 资源文件夹
     */
    public void addPath(String path){

    }

    /**增加归档文件（zip）到资源池
     * @param path  压缩文件路径
     */
    public void addArchive(String path){

    }

    public Image getImageByMd5(String md5){
        return null;
    }
    public Image getImageByMsgSvrId(long svrid){
        return null;
    }
    public Image getImageByMsg(BaseMessage msg){
        return null;
    }


}
