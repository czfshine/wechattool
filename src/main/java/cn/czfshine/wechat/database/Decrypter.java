package cn.czfshine.wechat.database;

import org.apache.commons.codec.digest.DigestUtils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


/**
 * @author:czfshine
 * @date:2018/2/23 14:17
 */

public class Decrypter {
    //TODO
    private static String getKey(String imei,String uin) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        DigestUtils.md5Hex((imei+uin));

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
