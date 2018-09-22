package cn.czfshine.wechat.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:czfshine
 * @date:2018/9/22 19:28
 */

public class DataBase {

    private List<MsgDataBase> msgDataBases;
    private static  Logger logger;
    static {
        logger = LoggerFactory.getLogger("");
    }
    public DataBase(String path){
        this(new String[]{path});
    }
    public DataBase(String[] datafiles){
        logger.info("开始解析数据库：");
        msgDataBases=new LinkedList<>();
        for(String path:datafiles){
            try{
                logger.info("开始解析数据库{}：",path);
                MsgDataBase msgDataBase=readMsgDB(path);
                msgDataBases.add(msgDataBase);

            } catch (Exception e) {
                logger.error("解析数据库{}失败：",path);
                e.printStackTrace();
            }
        }
    }

    private final String DBFILEEXT="db";
    private MsgDataBase readMsgDB(String path) throws SQLException, IOException, ClassNotFoundException {
        if(path.endsWith(DBFILEEXT)){
            return new MsgDataBase(path);
        }else{
            return MsgDataBase.buildFromFile(path);
        }
    }

}
