package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class XmlMessage extends Message {
    public  final MSGTYPE TYPE;
    protected String xml;
    public XmlMessage(ResultSet rs) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(rs);
        TYPE=MSGTYPE.getType(rs.getInt("type"));

    }
    public  void init(ResultSet rs) throws SQLException {
        xml=rs.getString("content");
    }
}
