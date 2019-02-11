package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.resources.Resources;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * 语音消息
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class AudioMessage extends BaseMessage implements Serializable {
    //private Logger logger=LoggerFactory.getLogger("audM");
    private static final long serialVersionUID = -7734023615186363037L;
    private String audioPath;
    public static final MSGTYPE TYPE = MSGTYPE.TYPE_SPEAK;

    public AudioMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);

    }

    private void init(MessageDO messageDO) throws SQLException {
        String imgPath = messageDO.getImgPath();
        audioPath= Resources.getResources().getAudioByImgpath(imgPath);
        setTalker(messageDO.getContent());
    }

    public String getAudioPath() {
        return audioPath;
    }
}