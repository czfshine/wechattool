package cn.czfshine.wechat.image; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* ImageDatabase Tester. 
* 
* @author <Authors name> 
* @since <pre>02/22/2018</pre> 
* @version 1.0 
*/ 
public class ImageDatabaseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: init() 
* 
*/ 
@Test
public void testInit() throws Exception { 
//TODO: Test goes here... 

    new ImageDatabase("data/db/decrypted171028.db");

} 

/** 
* 
* Method: getAllImageInfoFromDatabase() 
* 
*/ 
@Test
public  void testGetBImageInfoFromDatabase() throws Exception {
//TODO: Test goes here... 

try { 
   Method method = ImageDatabase.class.getDeclaredMethod("getBigImageInfoFromDatabase");
   method.setAccessible(true);
   method.invoke(new ImageDatabase("data/db/decrypted171028.db"));

} catch(NoSuchMethodException e) {
    System.out.println(e);
} catch(IllegalAccessException e) {
    System.out.println(e);
} catch(InvocationTargetException e) {
    System.out.println(e);
} 

} 

} 
