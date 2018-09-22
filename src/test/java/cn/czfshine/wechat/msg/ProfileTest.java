package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.MsgDataBase;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/25 21:08
 */

public class ProfileTest {

    @Test
    public void TestAll() throws SQLException {
        MsgDataBase db=new MsgDataBase("data/db/decrypted180223.db");
        db.getAllChatRoom();
    }
}
