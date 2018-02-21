package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.display.TextOutput;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/21 10:53
 */

public class TextOutputTest {
    static String testdbpath="data/db/decrypted171028.db";

    @Test
    public void TextMassageOutputTest() throws SQLException {
        MsgDataBase db= new MsgDataBase(testdbpath);
        Message[] msgs=db.getAllMsgssage();
        TextOutput.toTextFile(msgs);
        return ;
    }
}
