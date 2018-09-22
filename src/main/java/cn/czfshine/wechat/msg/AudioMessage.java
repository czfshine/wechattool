package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 语音消息
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class AudioMessage extends Message implements Serializable {
    private static final long serialVersionUID = -7734023615186363037L;
    private String md5;

    public static final MSGTYPE TYPE = MSGTYPE.TYPE_SPEAK;

    public AudioMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        init(rs);

    }

    private void init(ResultSet rs) throws SQLException {
        md5 = rs.getString("imgPath");
    }
}