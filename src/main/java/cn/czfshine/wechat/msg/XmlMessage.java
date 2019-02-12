package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class XmlMessage extends BaseMessage {
    public  final MSGTYPE TYPE;
    protected String xml;
    protected Document document;
    public XmlMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE=MSGTYPE.getType(messageDO.getType());
        init(messageDO);
    }
    public  void init(MessageDO messageDO) throws SQLException {
        xml=setTalker(messageDO.getContent());
        xml=xml.replace("&","__and__");
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(TYPE);
    }
}
