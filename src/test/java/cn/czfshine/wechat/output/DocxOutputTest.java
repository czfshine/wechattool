package cn.czfshine.wechat.output; 

import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.msg.Message;
import cn.czfshine.wechat.msg.MsgDataBase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* DocxOutput Tester. 
* 
* @author <Authors name> 
* @since <pre>02/23/2018</pre> 
* @version 1.0 
*/ 
public class DocxOutputTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toDocx(Message[] msgs) 
* 
*/ 
@Test
public void testToDocx() throws Exception {
    MsgDataBase msgDataBase = new MsgDataBase("data/db/decrypted171028.db");
    List<Contact> allChatRoom = msgDataBase.getAllChatRoom();
    List<Message> messages = allChatRoom.get(0).getMessages();
    Message[] msg = new Message[messages.size()];
    DocxOutput.toDocx( messages.toArray(msg));

} 

/** 
* 
* Method: main(String [] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 
