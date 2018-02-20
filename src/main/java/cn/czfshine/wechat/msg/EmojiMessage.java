package cn.czfshine.wechat.msg;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/20 23:48
 */

public class EmojiMessage  extends Message{
    private String md5;
    EmojiMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        TYPE=MSGTYPE.TYPE_EMOJI;
        init(rs);
    }

    private void init(ResultSet rrs) throws SQLException {
        //TODO:* WTF TALKER
        md5= rrs.getString("imgPath");
    }
}
