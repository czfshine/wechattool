package cn.czfshine.wechat.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:czfshine
 * @date:2018/2/22 21:02
 */

public class ImageDatabase {

    private String path;
    private Connection connection;

    Logger logger = LoggerFactory.getLogger("imgdb");

    public  ImageDatabase(String path) throws SQLException {
        this.path=path;
        init();
    }

    private void init() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);
    }

    public List<BigImage> getBigImageInfoFromDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT msgSvrId, bigImgPath, thumbImgPath FROM ImgInfo2");
        logger.info("开始读取图片记录");

        List<BigImage> bigImages =new ArrayList<>();

        int count=0;
        while(resultSet.next()){
            count++;
            long msgid=resultSet.getLong("msgSvrId");
            String bigimg= resultSet.getString("bigImgPath");
            if(!bigimg.startsWith("SERVERID://")){
                bigImages.add(new BigImage(msgid,bigimg));
            }

        }
        logger.info("一共有{}条图片记录，本地只有{}张原图",count, bigImages.size());
        return bigImages;
    }
}
