package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表情
 * @author:czfshine
 * @date:2018/2/20 23:48
 */

public class EmojiMessage  extends Message implements Serializable {
    private String md5;

    public static final MSGTYPE TYPE=MSGTYPE.TYPE_EMOJI;
    public EmojiMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        init(rs);
    }

    private void init(ResultSet rrs) throws SQLException {
        //TODO:* WTF TALKER
        md5= rrs.getString("imgPath");
    }
}
