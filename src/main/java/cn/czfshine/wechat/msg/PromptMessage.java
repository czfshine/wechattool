package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class PromptMessage extends BaseMessage {
    private String text;
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_YUYIN;
    public PromptMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        init(rs);
    }

    public void init(ResultSet rs) throws SQLException {
        text=rs.getString("content");
        talker= Talker.SYSTEM;
    }
}
