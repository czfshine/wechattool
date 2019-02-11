package cn.czfshine.wechat.emoji;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmojiDataBaseTest {

    @Before
    public void setUp() throws Exception {
        new EmojiDataBase("/home/czfshine/workplace/wechat/data/db/decrypted20190209.db");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test(){

    }
}