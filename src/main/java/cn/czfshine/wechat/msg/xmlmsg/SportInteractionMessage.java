package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;

import java.sql.SQLException;

public class SportInteractionMessage extends XmlMessage {
    public final MSGTYPE TYPE;
    private String title;
    public SportInteractionMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }
    private void init() {
        title=document.getRootElement().element("appmsg").element("title").getText();
    }
}
