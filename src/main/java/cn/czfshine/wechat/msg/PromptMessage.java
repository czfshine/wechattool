package cn.czfshine.wechat.msg;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class PromptMessage extends Message {
    private String text;

    public PromptMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        TYPE=MSGTYPE.TYPE_YUYIN;
        init(rs);
    }

    public void init(ResultSet rs) throws SQLException {
        text=rs.getString("content");
        talker="SYSTEM";
    }
}
