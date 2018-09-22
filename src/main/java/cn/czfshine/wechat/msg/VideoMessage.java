package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class VideoMessage extends Message {
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_SPEAK;
    private String md5;
    public VideoMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);

    }
    private void init(ResultSet rs) throws SQLException {
        md5=rs.getString("imgPath");
    }
}
