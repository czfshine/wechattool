package cn.czfshine.wechat.database; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

/** 
* Decrypter Tester. 
* 
* @author <Authors name> 
* @since <pre>02/23/2018</pre> 
* @version 1.0 
*/ 
public class DecrypterTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: decryptDataBase(String encryptpath, String imei, String uin, String outputpath)
     */
    @Test
    public void testDecryptDataBase() throws Exception {
        Decrypter.decryptDataBase("", "866427", "-13", "");
    }


    /**
     * Method: getKey(String imei, String uin)
     */
    @Test
    public void testGetKey() throws Exception {


        Method method = Decrypter.class.getDeclaredMethod("getKey", String.class, String.class);
        method.setAccessible(true);
        assertEquals(method.invoke(null, new Object[]{"", ""}),"d41d8cd");
        assertEquals(method.invoke(null, new Object[]{"12345678", "987654321"}),"8aea624");
        assertEquals(method.invoke(null, new Object[]{"", "987654321"}),"6ebe76c");
        assertEquals(method.invoke(null, new Object[]{"12345678", ""}),"25d55ad");
    }
}
