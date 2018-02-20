package cn.czfshine.wechat.msg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author:czfshine
 * @date:2018/2/20 22:47
 */

public class TextMessage extends Message {
    private String content;
    public TextMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        TYPE=MSGTYPE.TYPE_MSG;
        init(rs);
    }

    private void init(ResultSet rs) throws SQLException, DatabaseDamagedException {
        content=rs.getString("content");
        if(!talker.equals("me")){
            if(chatroom.endsWith("@chatroom")){
                talker = content.substring(0,content.indexOf(":"));
                content=content.substring(content.indexOf(":")+2);
            }
        }
    }
    @Override
    public String toString(){
        return String.format("[msg]%s - %s:%s",time.toString(),talker,content);
    }
}
