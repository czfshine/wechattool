package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.image.ImagePool;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * 图片
 * @author:czfshine
 * @date:2018/2/20 23:11
 */

public class ImageMessage extends BaseMessage implements Serializable {

    public String getMd5() {
        return md5;
    }

    private String md5;
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_IMG;
    public ImageMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }


    private void init(MessageDO messageDO) throws SQLException {
        md5 =messageDO.getImgPath();
        setTalker(messageDO.getContent());
        if(md5.startsWith("THUMBNAIL_DIRPATH://th_")){
            md5=md5.substring(23);
            //todo
            //ImagePool.getThepool().add(md5);

        }else{
            LoggerFactory.getLogger("imgmsg").error("错误的图片文件名{}",md5);
        }


    }

    @Override
    public String toString(){
        return String.format("[msg]%s - %s:%s",time.toString(),talker, md5);
    }


}
