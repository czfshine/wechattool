package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;

import java.sql.SQLException;

public class TransferMessage extends XmlMessage {
    public final MSGTYPE TYPE;

    private String num;
    private boolean take;
    public TransferMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }
    private void init() {
        num=document.getRootElement().element("appmsg").element("wcpayinfo").element("feedesc").getText();
        String subtype= document.getRootElement().element("appmsg").element("wcpayinfo").element("paysubtype").getText();
        switch (subtype){
            case "1"://收到钱
                take=true;
                break;
            case "3":
                take=false;
                break;
                default:
                    break;

        }
    }
}
