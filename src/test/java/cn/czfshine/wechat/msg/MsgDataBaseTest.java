package cn.czfshine.wechat.msg;


import cn.czfshine.wechat.msg.contant.Contact;
import org.junit.Test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author:czfshine
 * @date:2018/2/16 16:00
 */

public class MsgDataBaseTest {

    static String testdbpath="data/db/decrypted171028.db";
    MsgDataBase db= new MsgDataBase(testdbpath);

    Logger logger = LoggerFactory.getLogger("UnitTest");

    public MsgDataBaseTest() throws SQLException {
    }

    @Test
    public void getAllConTactTest() throws SQLException {
        Map<String,Contact> contacts=db.getAllConTact();

    }
    @Test
    public void getAllMegssageTest() throws SQLException {
        db.getAllMsgssage();
    }

    @Test
    public void getAllChatroomTest() throws SQLException {

        String[] res=db.getAllChatRoom(db.getAllMsgssage());
        for(String x : res){
            logger.debug(x);
        }
    }

    @Test
    public void popAllMessageToContactTest() throws SQLException {
        db.popAllMessageToContact();
    }

}