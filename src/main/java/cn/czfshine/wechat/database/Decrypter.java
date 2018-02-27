package cn.czfshine.wechat.database;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 对加密后的微信数据库进行解密[待完成]
 * @author:czfshine
 * @date:2018/2/23 14:17
 */

public class Decrypter {


    /**
     * 得到密钥
     * @param imei 手机的imei码
     * @param uin 微信数据文件里面的uin码
     * @return 密钥
     */
    private static String getKey(String imei,String uin)  {
        return DigestUtils.md5Hex((imei+uin)).substring(0,7);
    }

    public static void DecryptDataBase(String encryptpath,String imei,String uin,String outputpath) throws UnsupportedEncodingException, NoSuchAlgorithmException, SQLException {

        String key = getKey(imei,uin);
        System.out.println(key);
        Connection connection = DriverManager.getConnection("jdbc:sqlite:"+encryptpath);
        Statement statement = connection.createStatement();
        System.out.println(
        statement.execute("PRAGMA key = ;\n" +
                "PRAGMA cipher_use_hmac = OFF;\n" +
                "PRAGMA cipher_page_size = 1024;\n" +
                "PRAGMA kdf_iter = 4000;\n" +
                "ATTACH DATABASE test.db AS db KEY '';"+
                "SELECT sqlcipher_export('db');"+
                "DETACH DATABASE db;"));
        System.out.println(statement.getWarnings());


    }
}
