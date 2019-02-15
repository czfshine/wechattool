package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;
import org.dom4j.Element;

import java.sql.SQLException;

public class SportMessage extends XmlMessage {
    public final MSGTYPE TYPE;
    private String rank;
    private String score;
    public SportMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }
    private void init() {
        Element rankinfo = document.getRootElement().element("appmsg")
                .element("hardwareinfo").element("messagenodeinfo").element("rankinfo");
        rank=rankinfo.element("rank").element("rankdisplay").getText();
        score=rankinfo.element("score").element("scoredisplay").getText();

        //todo:其他排名信息
    }
}
