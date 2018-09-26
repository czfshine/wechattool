package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.apache.commons.lang3.StringEscapeUtils;

import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class XmlMessage extends BaseMessage {
    public  final MSGTYPE TYPE;
    protected String xml;
    public XmlMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE=MSGTYPE.getType(messageDO.getType());
        init(messageDO);
    }
    public  void init(MessageDO messageDO) throws SQLException {
        xml=setTalker(messageDO.getContent());
    }
}
