package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.image.ImagePool;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.exit;

/**
 * @author:czfshine
 * @date:2018/2/20 23:11
 */

public class ImageMessage extends Message {

    private String md5;

    public ImageMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        TYPE=MSGTYPE.TYPE_IMG;
        init(rs);
    }


    public void init(ResultSet rs) throws SQLException {
        md5 =rs.getString("imgPath");
        String  content=rs.getString("content");
        if(!talker.equals("me")){
            if(chatroom.endsWith("@chatroom")){
                talker = content.substring(0,content.indexOf(":"));
            }
        }
        if(md5.startsWith("THUMBNAIL_DIRPATH://th_")){
            ImagePool.getThepool().add(md5.substring(23));
        }else{
            LoggerFactory.getLogger("imgmsg").error("错误的图片文件名{}",md5);
        }


    }

    @Override
    public String toString(){
        return String.format("[msg]%s - %s:%s",time.toString(),talker, md5);
    }


}
