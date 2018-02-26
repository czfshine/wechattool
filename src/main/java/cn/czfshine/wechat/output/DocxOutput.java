package cn.czfshine.wechat.output;

import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.msg.ImageMessage;
import cn.czfshine.wechat.msg.Message;
import cn.czfshine.wechat.msg.MessageUtils;
import cn.czfshine.wechat.msg.MsgDataBase;
import cn.czfshine.wechat.output.docx.DocxFile;
import cn.czfshine.wechat.output.docx.ImagePart;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.lang3.StringEscapeUtils;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * @author:czfshine
 * @date:2018/2/23 22:34
 */

public class DocxOutput {
    private static Logger logger=LoggerFactory.getLogger("docout");

    public static void toDocx(Message[] msgs) throws Docx4JException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();
        List<Message> messages=new ArrayList<>();

        int count=0;
        for(int i=0;i<msgs.length;i++){
            try{
            if(msgs[i] instanceof Docxable){
                mdp.addParagraph((((Docxable )msgs[i]).getDocxHead(msgs[i])));
                mdp.addParagraph((((Docxable )msgs[i]).getDocxxml()));
                count++;
            }else{
                messages.add(msgs[i]);
            }
            }catch (Exception e){
                messages.add(msgs[i]);
                logger.warn("第{}条消息解析出错，内容为{}",i,(((Docxable )msgs[i]).getDocxxml()));
                e.printStackTrace();
            }
        }

        logger.info("导出{}条信息成功，其中{}条消息未导出",count,msgs.length-count);
        MessageUtils.StatisType(messages);
        Docx4J.save(wordMLPackage, new java.io.File("./data/output/doc.docx"), Docx4J.FLAG_SAVE_ZIP_FILE);

    }
    public static void toDocx(List<Message> msgs) throws Docx4JException, JAXBException {
        toDocx(msgs.toArray(new Message[0]));
    }


    public  static void main(String [] args) throws IOException, ClassNotFoundException {
        MsgDataBase msgDataBase = MsgDataBase.buildFromFile("data/output/test1.obj");

        List<Contact> allChatRoom = msgDataBase.getAllChatRoom().subList(30,32);
        new File("data/output/doc/").mkdirs();

        for(Contact contact:allChatRoom){
            List<Message> messages = contact.getMessages();
            if(messages.size()>0)
                try {
                    DocxFile.toDocxFile("data/output/doc/" + contact.getNickname() + ".docx", messages);
                }catch (Exception e){
                e.printStackTrace();
                }
        }


    }
}
