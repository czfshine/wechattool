package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.resources.Resources;
import org.apache.commons.codec.digest.Md5Crypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
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
        audioPath= Resources.getResources().getAudoByImgpath(imgPath);
        setTalker(messageDO.getContent());
    }

    public String getAudioPath() {
        return audioPath;
    }
}