package cn.czfshine.wechat.image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    ImageDatabase db=new ImageDatabase("/home/czfshine/workplace/wechat/data/db/decrypted20190209.db");
    List<Image> bigImageInfoFromDatabase = db.getBigImageInfoFromDatabase();

    /*
    ImagePool pool=ImagePool.getThepool();
    /*for(Image image:bigImageInfoFromDatabase){
        pool.add(image);
    }*/
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
