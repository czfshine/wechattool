package cn.czfshine.wechat.msg;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class VideoMessage extends Message {
    private String md5;
    VideoMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        TYPE=MSGTYPE.TYPE_SPEAK;

    }
    private void init(ResultSet rs) throws SQLException {
        md5=rs.getString("imgPath");
    }
}
