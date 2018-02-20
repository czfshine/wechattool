package cn.czfshine.wechat.msg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author:czfshine
 * @date:2018/2/20 23:11
 */

public class ImageMessage extends Message {

    private String imagepath;

    public ImageMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        TYPE=MSGTYPE.TYPE_IMG;
        init(rs);
    }


    public void init(ResultSet rs) throws SQLException {
        imagepath=rs.getString("imgPath");
        String  content=rs.getString("content");
        if(!talker.equals("me")){
            if(chatroom.endsWith("@chatroom")){
                talker = content.substring(0,content.indexOf(":"));
            }
        }
    }

    @Override
    public String toString(){
        return String.format("[msg]%s - %s:%s",time.toString(),talker,imagepath);
    }


}
