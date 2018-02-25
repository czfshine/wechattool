package cn.czfshine.wechat.output;

import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.msg.Message;
import cn.czfshine.wechat.msg.MsgDataBase;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * @author:czfshine
 * @date:2018/2/23 22:34
 */

public class DocxOutput {


    public static void toDocx(Message[] msgs) throws Docx4JException, JAXBException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();
        for(int i=0;i<msgs.length;i++){
            if(msgs[i] instanceof Docxable){
                System.out.println(i);
                mdp.addParagraph((((Docxable )msgs[i]).getDocxHead(msgs[i])));
                mdp.addParagraph((((Docxable )msgs[i]).getDocxxml()));
            }
        }
        Docx4J.save(wordMLPackage, new java.io.File("./data/output/doc.docx"), Docx4J.FLAG_SAVE_ZIP_FILE);

    }
    public static void toDocx(List<Message> msgs) throws Docx4JException, JAXBException {
        toDocx(msgs.toArray(new Message[msgs.size()]));
    }

    public  static void main(String [] args) throws Docx4JException, IOException, ClassNotFoundException, JAXBException {
        MsgDataBase msgDataBase = MsgDataBase.buildFromFile("data/output/test1.obj");
        Contact contact = msgDataBase.getAllChatRoom().get(110);
        List<Message> messages = contact.getMessages();

        toDocx(messages);

    }
}
