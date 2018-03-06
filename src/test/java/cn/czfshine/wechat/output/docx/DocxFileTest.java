package cn.czfshine.wechat.output.docx; 

import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.msg.MsgDataBase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* DocxFile Tester. 
* 
* @author <Authors name> 
* @since <pre>02/27/2018</pre> 
* @version 1.0 
*/ 
public class DocxFileTest { 

    static MsgDataBase dataBase;
@Before
public void before() throws Exception { 
    dataBase=MsgDataBase.buildFromFile("data/output/test1.obj");
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toDocxFile(String filepath) 
* 
*/ 
@Test
public void testToDocxFileFilepath() throws Exception {
    Contact contact = dataBase.getAllChatRoom().get(1);
    new DocxFile(contact).toDocxFile();
//TODO: Test goes here... 
}

    @Test
    public void testToDocxFileAll()  {
        List<Contact> allChatRoom = dataBase.getAllChatRoom();
        for(Contact contact : allChatRoom){
            try {
                new DocxFile(contact).toDocxFile();
            }catch (NotMessageOfContactException e){
                //todo
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    /**
* 
* Method: toDocxFile() 
* 
*/ 
@Test
public void testToDocxFile() throws Exception { 
//TODO: Test goes here... 
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
   Method method = DocxFile.getClass().getMethod("init"); 
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
* Method: getHeadXml(Message message) 
* 
*/ 
@Test
public void testGetHeadXml() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("getHeadXml", Message.class); 
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
* Method: getTextXml(TextMessage message) 
* 
*/ 
@Test
public void testGetTextXml() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("getTextXml", TextMessage.class); 
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
* Method: addTextMessage(TextMessage message) 
* 
*/ 
@Test
public void testAddTextMessage() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("addTextMessage", TextMessage.class); 
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
* Method: addImageMessage(ImageMessage message) 
* 
*/ 
@Test
public void testAddImageMessage() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("addImageMessage", ImageMessage.class); 
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
* Method: addParagraph(String pxml) 
* 
*/ 
@Test
public void testAddParagraph() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("addParagraph", String.class); 
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
* Method: addImageFile(String path, String imageid) 
* 
*/ 
@Test
public void testAddImageFile() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("addImageFile", String.class, String.class); 
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
* Method: initDocx() 
* 
*/ 
@Test
public void testInitDocx() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("initDocx"); 
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
* Method: copyZipFile() 
* 
*/ 
@Test
public void testCopyZipFile() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("copyZipFile"); 
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
* Method: writeDocx() 
* 
*/ 
@Test
public void testWriteDocx() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("writeDocx"); 
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
* Method: writeDocument() 
* 
*/ 
@Test
public void testWriteDocument() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DocxFile.getClass().getMethod("writeDocument"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
