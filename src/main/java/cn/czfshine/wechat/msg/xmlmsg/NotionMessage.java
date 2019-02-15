package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;

import java.sql.SQLException;

public class NotionMessage extends XmlMessage {
    public final MSGTYPE TYPE;

    //标题
    private String title;
    private String des;
    public NotionMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }

    private void init() {
        title=document.getRootElement().element("appmsg").element("title").getText();//一定有,没有就是bug:)
        des=document.getRootElement().element("appmsg").element("des").getText();

        //todo :其他信息没弄
    }
}
