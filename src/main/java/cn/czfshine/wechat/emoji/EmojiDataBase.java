package cn.czfshine.wechat.emoji;

import cn.czfshine.wechat.resources.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EmojiDataBase {
    private String path;//数据库路径
    private Connection connection;//数据库链接

    Logger logger = LoggerFactory.getLogger("emjdb");

    public EmojiDataBase(String path) throws SQLException {
        this.path=path;
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);
        init();
    }
    private void init() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT md5, groupId,cdnUrl,desc FROM EmojiInfo " +
                            "left join (select md5,desc from EmojiInfoDesc) " +
                            "using (md5);")) {
                while (resultSet.next()) {
                    String md5 =resultSet.getString(1);
                    String groupid=resultSet.getString(2);
                    String cdnurl=resultSet.getString(3);
                    String desc=resultSet.getString(4);
                    Emoji emoji = new Emoji();

                    //todo :临时先这样
                    emoji.setDesc(desc);
                    emoji.setDownloadUrl(cdnurl);
                    emoji.setThumbImage(Resources.getResources().getEmojiThumb(groupid,md5));
                    emoji.setAnimated(false);
                    emoji.setCustomized(false);
                    EmojiPool.add(md5,emoji);
                }
            }
        }
    }
}
