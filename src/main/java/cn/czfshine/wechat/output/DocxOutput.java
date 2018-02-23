package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.Message;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 * @author:czfshine
 * @date:2018/2/23 22:34
 */

public class DocxOutput {


    public static void toDocx(Message[] msgs) throws Docx4JException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();

        for(int i=0;i<msgs.length;i++){
            if(msgs[i] instanceof PlainTextable){
                mdp.addParagraphOfText(((PlainTextable) msgs[i]).toPlainText());
            }
        }
        Docx4J.save(wordMLPackage, new java.io.File("./data/output/doc.docx"), Docx4J.FLAG_SAVE_ZIP_FILE);

    }
    public  static void main(String [] args) throws Docx4JException {
        }
}
