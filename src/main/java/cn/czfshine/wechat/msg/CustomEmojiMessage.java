package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.SQLException;

public class CustomEmojiMessage extends BaseMessage implements Serializable {
    private String xml;

    public static final MSGTYPE TYPE=MSGTYPE.TYPE_EMOJI;
    public CustomEmojiMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }

    private void init(MessageDO messageDO) throws SQLException {
        //TODO:* WTF TALKER
        xml= messageDO.getContent();
        if(!talker.getUsername().equals("me")) {
            if (chatroom.getUid().endsWith("@chatroom")) {
                int pos= xml.indexOf(":");
                if(pos==-1){
                    pos=xml.indexOf("*#*");
                }
                talker = Talker.getInstance(xml.substring(0,pos));
                xml = StringEscapeUtils.escapeXml11(xml.substring(pos + 2));
            }
        }
    }
}
