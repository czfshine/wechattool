package cn.czfshine.wechat.output.docx;

import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.msg.ImageMessage;
import cn.czfshine.wechat.msg.Message;
import cn.czfshine.wechat.msg.TextMessage;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import static org.apache.commons.compress.utils.IOUtils.copy;
import static org.apache.commons.lang3.StringEscapeUtils.escapeXml11;

/**
 * @author:czfshine
 * @date:2018/2/27 15:17
 */

public class DocxFile {

    private Contact contact;

    public DocxFile(Contact contact) throws IOException, NotMessageOfContactException {
        this.contact=contact;
        if(contact.getMessages().size()==0){
            throw new NotMessageOfContactException();
        }
        init();
    }

    private void init() throws IOException {
        allxmlcontant=new StringBuilder(contact.getMessages().size()*1000);//todo
        in = new ZipFile("data/in/in.docx");
    }
    private String outputfilepath;

    public void toDocxFile(String filepath) throws IOException, NotMessageOfContactException {
        getAllMessageXml();
        if(allxmlcontant.length()==0){
            in.close();//todo
            throw new NotMessageOfContactException();
        }
        outputfilepath=filepath;

        initDocx();
        writeDocx();
    }

    private void getAllMessageXml() {
        for(Message msg:contact.getMessages()){
            if(msg instanceof TextMessage){
                addTextMessage((TextMessage) msg);
                continue;
            }
//
//            if(msg instanceof  ImageMessage){
//                addImageMessage((ImageMessage)msg);
//                continue;
//            }

            //todo
        }
    }

    public void toDocxFile() throws IOException, NotMessageOfContactException {
        new File("data/output/docx/").mkdirs();
        toDocxFile("data/output/docx/"+contact.getNickname().replaceAll("[/\\\\:*?<>|]","")+".docx");
    }


    private void putHeadXml(Message message){
        formatHead(DATE_FORMAT.format(message.getTime()),
                message.getTalkerName());
    }
    private String getTextXml(TextMessage message){
        return  String.format(TEXTPATT,message.getContent().replaceAll("&#[\\d]+",""));

    }

    private void addTextMessage(TextMessage message){
        putHeadXml(message);
        addParagraph(getTextXml(message));
    }

    private void addImageMessage(ImageMessage message){
        //todo
    }

    private StringBuilder allxmlcontant;

    private void addParagraph(String pxml){

        allxmlcontant.append(pxml);
    }

    private void addImageFile(String path,String imageid){
        //todo
    }


    private ZipArchiveOutputStream outfile;
    private void initDocx() throws IOException {
        outfile= new ZipArchiveOutputStream( new BufferedOutputStream(
                new FileOutputStream(outputfilepath)));
        copyZipFile();
    }


    private ZipFile in;
    private void copyZipFile() throws IOException {
        Enumeration<ZipArchiveEntry> entries = in.getEntries();
        ZipArchiveEntry e;
        ZipArchiveEntry e1;
        while(entries.hasMoreElements()){
            e1 = entries.nextElement();
            outfile.putArchiveEntry(e1);

            if (!e1.isDirectory()) {
                copy(in.getInputStream(e1), outfile);
            }
            outfile.closeArchiveEntry();
        }
    }

    private void writeDocx() throws IOException {
        if(allxmlcontant.length()>0){
            writeDocument();
        }
        //todo
        outfile.flush();
        outfile.close();
        in.close();

    }

    private void writeDocument() throws IOException {

        outfile.putArchiveEntry(new ZipArchiveEntry("word/document.xml"));

        outfile.write(DOCHEAD.getBytes());
        outfile.write(allxmlcontant.toString().getBytes());
        outfile.write(DOCTAIL.getBytes());
        outfile.closeArchiveEntry();
    }

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    private final static String HEADHEAD;
    private final static String HEADCON;
    private final static String HEADTAI;
    private void formatHead(String format, String talkerName) {
        allxmlcontant.append(HEADHEAD);
        allxmlcontant.append(format);
        allxmlcontant.append(HEADCON);
        allxmlcontant.append(talkerName);
        allxmlcontant.append(HEADTAI);
    }
    static {
        HEADHEAD = "<w:p xmlns:v=\"urn:schemas-microsoft-com:vml \"\n" +
                "     xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\"\n" +
                "        xmlns:o=\"urn:schemas-microsoft-com:office:office \"\n" +
                "        xmlns:w10=\"urn:schemas-microsoft-com:office:word\"\n" +
                "        w:rsidR=\"00386596\" w:rsidRDefault=\"00386596\">\n" +
                "    <w:pPr>\n" +
                "        <w:rPr>\n" +
                "            <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "        </w:rPr>\n" +
                "    </w:pPr>\n" +
                "    <w:r w:rsidRPr=\"00386596\">\n" +
                "        <w:rPr>\n" +
                "            <w:rFonts w:ascii=\"黑体\" w:eastAsia=\"黑体\" w:hAnsi=\"黑体\"/>\n" +
                "            <w:sz w:val=\"24\"/>\n" +
                "            <w:szCs w:val=\"24\"/>\n" +
                "            <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "        </w:rPr>\n" +
                "        <w:t>" ;
        HEADCON="</w:t>\n" +
                "    </w:r>\n" +
                "    <w:r w:rsidRPr=\"00386596\">\n" +
                "        <w:rPr>\n" +
                "            <w:b/>\n" +
                "            <w:sz w:val=\"32\"/>\n" +
                "            <w:szCs w:val=\"32\"/>\n" +
                "            <w:highlight w:val=\"green\"/>\n" +
                "            <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "        </w:rPr>\n" +
                "        <w:t>";
        HEADTAI="</w:t>\n" +
                "    </w:r>\n" +
                "</w:p>";
    }

    private final static   String TEXTPATT;
    static {
        TEXTPATT = "<w:p " +
                "xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\">" +
                "w:rsidR=\"00CA063F\" w:rsidRPr=\"00386596\" w:rsidRDefault=\"00386596\" w:rsidP=\"00386596\">\n" +
                "\t<w:pPr>\n" +
                "\t\t<w:ind w:left=\"420\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t\t<w:rFonts w:ascii=\"微软雅黑\" w:eastAsia=\"微软雅黑\" w:hAnsi=\"微软雅黑\"/>\n" +
                "\t\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r w:rsidRPr=\"00386596\">\n" +
                "\t\t<w:rPr>\n" +
                "\t\t\t<w:rFonts w:ascii=\"微软雅黑\" w:eastAsia=\"微软雅黑\" w:hAnsi=\"微软雅黑\"/>\n" +
                "\t\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t><![CDATA[%s]]></w:t>\n" +
                "\t</w:r>\n" +
                "</w:p>";
    }

    private static final String DOCHEAD="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<w:document xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:w15=\"http://schemas.microsoft.com/office/word/2012/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 w15 wp14\"><w:body>";
    private  static final String DOCTAIL=" \n" +
            "<w:sectPr w:rsidR=\"00D320F1\"><w:pgSz w:w=\"11906\" w:h=\"16838\"/><w:pgMar w:top=\"1440\" w:right=\"1800\" w:bottom=\"1440\" w:left=\"1800\" w:header=\"851\" w:footer=\"992\" w:gutter=\"0\"/><w:cols w:space=\"425\"/><w:docGrid w:type=\"lines\" w:linePitch=\"312\"/></w:sectPr></w:body></w:document>";


}
