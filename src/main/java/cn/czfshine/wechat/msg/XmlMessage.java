package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.xmlmsg.GroupMessage;
import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import java.sql.SQLException;

import static cn.czfshine.wechat.msg.MSGTYPE.*;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class XmlMessage extends BaseMessage {
    public  final MSGTYPE TYPE;
    protected String xml;
    protected Document document;
    private String title;
    public XmlMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE=MSGTYPE.getType(messageDO.getType());
        init(messageDO);
    }

    protected String replaceXmlSymbol(String xml){
        return xml.replace("&","__and__");
    }

    protected String resumeXmlSymbol(String xml){
        return xml.replace("__and__","&");
    }

    public  void init(MessageDO messageDO) throws SQLException {
        xml=setTalker(messageDO.getContent());
        xml=replaceXmlSymbol(xml);
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        /*
        //所有已处理的XML类型
        if(TYPE!=MSGTYPE.TYPE_BUSINESSCARD
                && TYPE!=MSGTYPE.TYPE_LINK
                &&TYPE!=MSGTYPE.TYPE_LOCATION
                && TYPE!=MSGTYPE.TYPE_SPORT
                && TYPE!= MSGTYPE.TYPE_SPOERINTERACTION
                && TYPE!=MSGTYPE.TYPE_TRANSFER
                && TYPE!=TYPE_APP_MSG
                && TYPE!= TYPE_APP_NOTION
                && TYPE!= TYPE_LOCATION_SHARING
                && TYPE!=TYPE_LOCATION_SHARING_D
                && TYPE!=TYPE_REDENVELOPE
                && TYPE!=TYPE_SHEAR
                && TYPE!=TYPE_APP
                )
            System.out.println(TYPE);*/
        if(TYPE== TYPE_LOCATION_SHARING || TYPE==TYPE_LOCATION_SHARING_D){
            title="我发起了位置共享";
        }
    }
}
