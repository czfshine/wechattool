package cn.czfshine.wechat.output.docx; 


import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.image.ImagePool;
import cn.czfshine.wechat.msg.ImageMessage;
import cn.czfshine.wechat.msg.Message;
import cn.czfshine.wechat.msg.MsgDataBase;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;

import static org.apache.commons.compress.utils.IOUtils.copy;

/** 
* ImagePart Tester. 
* 
* @author <Authors name> 
* @since <pre>02/26/2018</pre> 
* @version 1.0 
*/ 
public class ImagePartTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toDocx(ImageMessage message, ZipArchiveOutputStream docxfile) 
* 
*/ 
@Test
public void testToDocx() throws Exception {
    MsgDataBase msgDataBase = MsgDataBase.buildFromFile("data/output/test1.obj");
    Contact contact = msgDataBase.getAllChatRoom().get(13);
    List<Message> messages = contact.getMessages();
    ImagePart imagePart=new ImagePart();
    ZipFile in = new ZipFile("data/in/in.docx");

    ZipArchiveOutputStream append = new ZipArchiveOutputStream(
            new FileOutputStream("data/output/imagrpart.docx"));
    Enumeration<ZipArchiveEntry> entries = in.getEntries();
    ZipArchiveEntry e;
    ZipArchiveEntry e1;
    while(entries.hasMoreElements()){
        e1 = entries.nextElement();
        append.putArchiveEntry(e1);

        if (!e1.isDirectory()) {
            copy(in.getInputStream(e1), append);
        }
        append.closeArchiveEntry();
    }


    Method method = ImagePart.class.getDeclaredMethod("getImage", ImageMessage.class);
        method.setAccessible(true);
        for(Message msg:messages) {
            if (msg instanceof ImageMessage) {

                System.out.println(imagePart.getDocxXml((ImageMessage) msg,append));
            }
        }

    append.flush();
    append.close();
    in.close();
}




    /**
* 
* Method: format() 
* 
*/ 
@Test
public void testFormat() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ImagePart.getClass().getMethod("format"); 
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
* Method: addImageFile(ZipArchiveOutputStream docxfile) 
* 
*/ 
@Test
public void testAddImageFile() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ImagePart.getClass().getMethod("addImageFile", ZipArchiveOutputStream.class); 
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
* Method: setImagenvPicPr() 
* 
*/ 
@Test
public void testSetImagenvPicPr() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ImagePart.getClass().getMethod("setImagenvPicPr"); 
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
* Method: writeToDocx(ZipArchiveOutputStream docfile) 
* 
*/ 
@Test
public void testWriteToDocx() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ImagePart.getClass().getMethod("writeToDocx", ZipArchiveOutputStream.class); 
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
* Method: getImage(ImageMessage message) 
* 
*/ 
@Test
public void testGetImage() throws Exception {
    MsgDataBase msgDataBase = MsgDataBase.buildFromFile("data/output/test1.obj");
    Contact contact = msgDataBase.getAllChatRoom().get(0);
    List<Message> messages = contact.getMessages();
    System.out.println(ImagePool.getThepool().getThumbnailFileCount());
    try {
        ImagePart imagePart=new ImagePart();
        Method method = ImagePart.class.getDeclaredMethod("getImage", ImageMessage.class);
        method.setAccessible(true);
        for(Message msg:messages){
            if(msg instanceof ImageMessage){
                long id= (long) method.invoke(imagePart, msg);
                if(id>0){
                    System.out.println(msgDataBase.getMsgFromMsgId(id));
                }
            }
        }

    } catch(NoSuchMethodException e) {
        e.printStackTrace();
    }


} 

} 
