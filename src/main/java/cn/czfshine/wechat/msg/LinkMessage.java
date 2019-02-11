package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.sql.SQLException;

public class LinkMessage extends BaseMessage {
    public  final MSGTYPE TYPE;
    protected String xml;
    public LinkMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE=MSGTYPE.getType(messageDO.getType());
        init(messageDO);
    }
    public  void init(MessageDO messageDO) throws SQLException {
        //
        // xml=StringEscapeUtils.escapeXml11(setTalker(messageDO.getContent()));
        xml=setTalker(messageDO.getContent());
        //todo
    }
}
