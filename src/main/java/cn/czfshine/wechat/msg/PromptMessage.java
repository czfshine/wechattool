package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;

import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class PromptMessage extends BaseMessage {
    private String text;
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_YUYIN;
    public PromptMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }

    public void init(MessageDO messageDO) throws SQLException {
        text=messageDO.getContent();
        talker= Talker.getInstance("system");
    }
}
