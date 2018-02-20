package cn.czfshine.wechat.msg;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.applet.resources.MsgAppletViewer_sv;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * 用来操作微信聊天数据库，要使用解密后的数据库文件
 *
 * @author:czfshine
 * @date:2018/1/15 17:52
 */

public class MsgDataBase {
    private String datapath;
    private String selfid="self";

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
                "SELECT  msgSvrId,type,isSend,createTime,talker,content,imgPath  FROM message  ");
        Logger logger = LoggerFactory.getLogger("DBofmsg");
        logger.info("开始读取聊天");
        int count=0;
        ArrayList<Message> msgs=new ArrayList<>();
        while (rs.next()) {
            count++;

            try {
                Message msg=parseMsgRow(rs);
                if(msg!=null) {
                    logger.debug(msg.toString());

                    msgs.add(msg);
                }

            }catch (DatabaseDamagedException e) {
                logger.warn("在数据库{}第{}条消息损坏",datapath,""+count);
            }catch (UnknowMassageTypeException w){
                logger.warn("类型{}未知，内容为：{}\n\t",datapath,""+count,""+w.getId(),rs.getString("content"));
            }catch (Exception e){
                logger.error("在数据库{}第{}条消息出错",datapath,""+count);
                throw e;
            }

        }
        logger.info("共读取{}条记录，解析成功{}条记录",count,msgs.size());
        Message[] res=new Message[msgs.size()];
        return msgs.toArray(res);


    }


    private Message parseMsgRow(ResultSet rs) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        int type= rs.getInt("type");

        MSGTYPE msgtype=MSGTYPE.getType(type);

        switch (msgtype){
            case TYPE_MSG:return new TextMessage(rs);
            case TYPE_IMG:return new ImageMessage(rs);
            case TYPE_EMOJI:return new EmojiMessage(rs);
        }

        return null;


    }
    public static void main(String[] args){
        new MsgDataBase("data/db/decrypted171028.db");
    }
}
