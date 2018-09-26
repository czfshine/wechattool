package cn.czfshine.wechat.database;

import cn.czfshine.wechat.database.MsgDataBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/** 
* MsgDataBase Tester. 
* 
* @author czfshine
* @since <pre>02/21/2018</pre> 
* @version 1.0 
*/ 
public class MsgDataBaseTest { 

    String path="data/db/decrypted171028.db";
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAllChatRoom(BaseMessage[] msgs)
* 
*/ 
@Test
public void testGetAllChatRoom() throws Exception { 
    MsgDataBase db=new MsgDataBase("data/db/decrypted171028.db");
    db.getAllChatRoom();
    int a=1;
} 


/** 
* 
* Method: getSelf() 
* 
*/ 
@Test
public void testGetSelf() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MsgDataBase.getClass().getMethod("getSelf"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: init() 
* 
*/ 
@Test
public void testInit() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MsgDataBase.getClass().getMethod("init"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: getAllConTact() 
* 
*/ 
@Test
public void testGetAllConTact() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MsgDataBase.getClass().getMethod("getAllConTact"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: getAllMsgssage() 
* 
*/ 
@Test
public void testGetAllMsgssage() throws Exception { 
//TODO: Test goes here... 

try {
    MsgDataBase db=new MsgDataBase("D:\\wc\\data/db/decrypted180223.db");
    Method method = MsgDataBase.class.getMethod("getAllMsgssage");
    method.setAccessible(true);
    method.invoke(db);

} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) {
} 

} 

/** 
* 
* Method: popAllMessageToContact() 
* 
*/ 
@Test
public void testPopAllMessageToContact() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MsgDataBase.getClass().getMethod("popAllMessageToContact"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: parseMsgRow(ResultSet rs) 
* 
*/ 
@Test
public void testParseMsgRow() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MsgDataBase.getClass().getMethod("parseMsgRow", ResultSet.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
}

    @Test
    public void testSave() throws SQLException, IOException {

        new MsgDataBase(path).save("data/output/test1.obj");
    }

    @Test
    public void testBuildFromFile() throws SQLException, IOException, ClassNotFoundException {
        MsgDataBase db = MsgDataBase.buildFromFile("data/output/test1.obj");
        //System.out.println(db.allmsgs.size());
    }



} 
