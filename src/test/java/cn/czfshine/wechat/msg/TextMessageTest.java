package cn.czfshine.wechat.msg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* TextMessage Tester. 
* 
* @author <Authors name> 
* @since <pre>02/23/2018</pre> 
* @version 1.0 
*/ 
public class TextMessageTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: toPlainText() 
* 
*/ 
@Test
public void testToPlainText() throws Exception {
    TextMessage message = new TextMessage(123, 12345678, "me", "233333", "whoareyou");
    System.out.println(message.toPlainText());
    message = new TextMessage(123, 12345678, "me", "233333", "你是谁");
    System.out.println(message.toPlainText());
    message = new TextMessage(123, 12345678, "me", "233333", "whoare" +
            "youggfgd\n" +
            "fgdfg\n" +
            "fggdgdf\n" +
            "gfgf\n" +
            "fgfdgdgdgdfgd\n");
    System.out.println(message.toPlainText());
    message = new TextMessage(123, 12345678, "me", "233333", "whoareyou");
    System.out.println(message.toPlainText());


}


/** 
* 
* Method: init(ResultSet rs) 
* 
*/ 
@Test
public void testInit() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TextMessage.getClass().getMethod("init", ResultSet.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
