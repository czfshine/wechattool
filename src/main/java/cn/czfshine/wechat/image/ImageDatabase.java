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

    private String path;//数据库路径
    private Connection connection;//数据库链接

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
        ImagePool thepool = ImagePool.getThepool();
        try (Statement statement = connection.createStatement()) {
            int count=0;
            try (ResultSet resultSet = statement.executeQuery("SELECT msgSvrId, bigImgPath,thumbImgPath FROM ImgInfo2")) {
                logger.info("开始读取图片记录");

                Images = new ArrayList<>();

                while (resultSet.next()) {
                    count++;
                    String msgid = resultSet.getString("msgSvrId");
                    String bigimg = resultSet.getString("bigImgPath");
                    String thpath=resultSet.getString("thumbImgPath");
                    //开始解析:

                        //1.如果以下面字符串开头的说明没下载过原图,最多只有预览图
                    if (bigimg.startsWith("SERVERID://")) {
                        Image image = new Image(thpath);
                        Images.add(image);
                        thepool.addImage(msgid,image);
                    }else{
                        //2.说明至少下载过原图
                        Image image=new Image(thpath,bigimg);
                        Images.add(image);
                        count++;
                        thepool.addImage(msgid,image);
                    }
                }
            }
            logger.info("一共有{}条图片记录，本地只有{}张原图和{}张预览图,缺失{}张",
                    count, thepool.getBigImgCount(),thepool.getThumbImgCount(),
                    count-thepool.getBigImgCount()-thepool.getThumbImgCount());
        }
        return Images;
    }
}
