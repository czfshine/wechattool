package cn.czfshine.wechat.image; 

import cn.czfshine.wechat.msg.MsgDataBase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/** 
* ImagePool Tester. 
* 
* @author <Authors name> 
* @since <pre>02/22/2018</pre> 
* @version 1.0 
*/ 
public class ImagePoolTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(Object obj) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
    ImageDatabase db=new ImageDatabase("data/db/decrypted171028.db");
    List<BigImage> images = db.getBigImageInfoFromDatabase();
    ImagePool pool=ImagePool.getThepool();
    for(BigImage image:images){
        pool.add(image);
    }
}


/** 
* 
* Method: findImageFiles(BigImage bigImage) 
* 
*/ 
@Test
public void testFindImageFiles() throws Exception { 
//TODO: Test goes here... 


} 

} 
