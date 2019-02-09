package cn.czfshine.wechat.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 从数据库中提取图片相关的数据
 * @author:czfshine
 * @date:2018/2/22 21:02
 */

public class ImageDatabase {

    private String path;
    private Connection connection;

    Logger logger = LoggerFactory.getLogger("imgdb");

    /**
     * @param path 数据库路径
     * @throws SQLException
     */
    public  ImageDatabase(String path) throws SQLException {
        this.path=path;
        init();
    }

    private void init() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);
    }


    public List<Image> getBigImageInfoFromDatabase() throws SQLException {
        List<Image> Images;
        try (Statement statement = connection.createStatement()) {
            int count=0;
            try (ResultSet resultSet = statement.executeQuery("SELECT msgSvrId, bigImgPath FROM ImgInfo2")) {
                logger.info("开始读取图片记录");

                Images = new ArrayList<>();

                while (resultSet.next()) {
                    count++;
                    long msgid = resultSet.getLong("msgSvrId");
                    String bigimg = resultSet.getString("bigImgPath");
                    if (!bigimg.startsWith("SERVERID://")) {
                        //Images.add(new Image(msgid, bigimg));
                    }

                }
            }
            logger.info("一共有{}条图片记录，本地只有{}张原图", count, Images.size());
        }
        return Images;
    }
}
