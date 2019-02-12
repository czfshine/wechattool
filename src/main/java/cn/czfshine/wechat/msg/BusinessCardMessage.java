package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;

import java.sql.SQLException;

public class BusinessCardMessage extends XmlMessage {
    public  final MSGTYPE TYPE;

    public String headImgUrl;
    public String nickname;
    public BusinessCardMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE=MSGTYPE.getType(messageDO.getType());
        init();
    }

    private void init(){
        if(document.getRootElement().getQName().getName().equals("msg")){
            headImgUrl=document.getRootElement().attribute("bigheadimgurl").getValue();
            nickname=document.getRootElement().attribute("nickname").getValue();
        }else{
            document.getDocType();
        }

    }

}
