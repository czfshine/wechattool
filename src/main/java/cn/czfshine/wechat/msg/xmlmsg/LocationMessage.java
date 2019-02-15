package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;

import java.sql.SQLException;

public class LocationMessage extends XmlMessage {
    public final MSGTYPE TYPE;

    private double x;
    private double y;
    private String label;
    public LocationMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }

    private void init() {
        x=Double.parseDouble(document.getRootElement().element("location").attribute("x").getValue());
        y=Double.parseDouble(document.getRootElement().element("location").attribute("y").getValue());
        label=document.getRootElement().element("location").attribute("label").getValue();
        //System.out.println(1);
    }
}
