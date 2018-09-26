package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class VideoMessage extends BaseMessage {
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_SPEAK;
    private String md5;
    public VideoMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }
    private void init(MessageDO messageDO) throws SQLException {
        md5=messageDO.getImgPath();
        setTalker(messageDO.getContent());
    }
}
