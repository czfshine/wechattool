package cn.czfshine.wechat.msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.applet.resources.MsgAppletViewer_sv;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 用来操作微信聊天数据库，要使用解密后的数据库文件
 *
 * @author:czfshine
 * @date:2018/1/15 17:52
 */

public class MsgDataBase {
    private String datapath;
    private String selfid;

    private void getSelf(){
        //TODO
    }
    private Connection connection;
    public MsgDataBase(String path){
        datapath=path;
        init();
    }

    private void init(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+datapath);
            

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /* 会话信息 */
    private Contact[] getAllConTact() throws SQLException {
        Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username,conRemark,nickname FROM rcontact");

            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("username")
                        + "\tRemark =" + rs.getString("conremark")
                        + "\tnickname =" + rs.getString("nickname"));
            }


        return null;
    }

    public Message[] getAllMsgssage() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT  msgSvrId,type,isSend,createTime,talker,content,imgPath  FROM message  limit 0,10");
        Logger logger = LoggerFactory.getLogger("DBofmsg");
        logger.info("开始读取聊天");
        int count=0;

        while (rs.next()) {
            count++;

                logger.warn("在数据库{}第{}条消息损坏",datapath,""+count);


            logger.info("talker=");

        }

        return null;


    }

    private Message parseMsgRow(ResultSet rs) throws SQLException {
        String talker=rs.getString("talker");

        if(talker==null ||talker.equals("")) {
        }
        return null;
    }


    public static void main(String[] args){
        new MsgDataBase("data/db/decrypted171028.db");
    }
}
