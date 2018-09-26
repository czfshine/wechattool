package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 语音消息
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class AudioMessage extends BaseMessage implements Serializable {
    private static final long serialVersionUID = -7734023615186363037L;
    private String md5;

    public static final MSGTYPE TYPE = MSGTYPE.TYPE_SPEAK;

    public AudioMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);

    }

    private void init(MessageDO messageDO) throws SQLException {
        md5 = messageDO.getImgPath();
    }
}