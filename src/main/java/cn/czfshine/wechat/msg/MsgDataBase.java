package cn.czfshine.wechat.msg;
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


    public static void main(String[] args){
        new MsgDataBase("data/db/decrypted171028.db");
    }
}
