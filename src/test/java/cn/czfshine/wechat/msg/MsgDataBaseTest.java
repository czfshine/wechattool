package cn.czfshine.wechat.msg;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* MsgDataBase Tester. 
* 
* @author czfshine
* @since <pre>02/21/2018</pre> 
* @version 1.0 
*/ 
public class MsgDataBaseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAllChatRoom(Message[] msgs) 
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
    MsgDataBase db=new MsgDataBase("data/db/decrypted171028.db");
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

} 
