package cn.czfshine.wechat.msg;


import org.junit.Test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/16 16:00
 */

public class MsgDataBaseTest {

    static String testdbpath="data/db/decrypted171028.db";

    @Test
    public void getAllConTactTest(){

        Logger logger = LoggerFactory.getLogger("");

        logger.info("Hello World");
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
    }
    @Test
    public void getAllMegssageTest() throws SQLException {
        MsgDataBase db= new MsgDataBase(testdbpath);
        db.getAllMsgssage();
    }

}