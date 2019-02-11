package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.resources.Resources;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/21 10:20
 */

public class VideoMessage extends BaseMessage {
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_SPEAK;
    private String thumbImgPath;
    private String videoPath;
    public VideoMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }
    private void init(MessageDO messageDO) throws SQLException {
        String imgPath = messageDO.getImgPath();
        thumbImgPath= Resources.getResources().getVideoThumbByImgpath(imgPath);
        videoPath= Resources.getResources().getVideoByImgpath(imgPath);
        setTalker(messageDO.getContent());
    }

    public String getThumbImgPath() {
        return thumbImgPath;
    }

    public String getVideoPath() {
        return videoPath;
    }
}
