package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.image.ImagePool;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 图片
 * @author:czfshine
 * @date:2018/2/20 23:11
 */

public class ImageMessage extends Message implements Serializable {

    public String getMd5() {
        return md5;
    }

    private String md5;
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_IMG;
    public ImageMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        init(rs);
    }


    private void init(ResultSet rs) throws SQLException {
        md5 =rs.getString("imgPath");
        String  content=rs.getString("content");
        if(!talker.equals("me")){
            if(chatroom.endsWith("@chatroom")){
                talker = content.substring(0,content.indexOf(":"));
            }
        }

        if(md5.startsWith("THUMBNAIL_DIRPATH://th_")){
            md5=md5.substring(23);
            ImagePool.getThepool().add(md5);

        }else{
            LoggerFactory.getLogger("imgmsg").error("错误的图片文件名{}",md5);
        }


    }

    @Override
    public String toString(){
        return String.format("[msg]%s - %s:%s",time.toString(),talker, md5);
    }


}
