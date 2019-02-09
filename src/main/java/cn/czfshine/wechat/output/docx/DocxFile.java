package cn.czfshine.wechat.output.docx;

import cn.czfshine.wechat.contant.Chatroom;
import cn.czfshine.wechat.image.Image;
import cn.czfshine.wechat.image.ImagePool;
import cn.czfshine.wechat.msg.BaseMessage;
import cn.czfshine.wechat.msg.ImageMessage;
import cn.czfshine.wechat.msg.TextMessage;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Iterator;

import static org.apache.commons.compress.utils.IOUtils.copy;

/**
 * @author:czfshine
 * @date:2018/2/27 15:17
 */

public class DocxFile {
    public DocxFile(Chatroom chatroom) throws IOException, NotMessageOfContactException {
        this.chatroom = chatroom;
        if(chatroom.getMessages().size()==0){
            throw new NotMessageOfContactException();
        }
        init();
    }
    public void toDocxFile(String filepath) throws IOException, NotMessageOfContactException {
        outputfilepath=filepath;
        initDocx();
        getAllMessageXml();
        if(allxmlcontant.length()==0){
            in.close();//todo
            throw new NotMessageOfContactException();
        }

        writeDocx();
    }
    public void toDocxFile() throws IOException, NotMessageOfContactException {
        new File("data/output/docx/").mkdirs();
        toDocxFile("data/output/docx/"+ chatroom.getNickname().replaceAll("[/\\\\:*?<>|]","")+".docx");
    }

    private static ImagePool imagePool;
    private static int maxHeight = 3600000;//图片高度
    private static int maxWidth = 5000000;//图片宽度
    private final static SimpleDateFormat DATE_FORMAT;
    private final static String HEADHEAD;
    private final static String HEADCON;
    private final static String HEADTAI;
    private final static String TEXTPATT;
    private final static String IMAGEPATT;
    private final static String RELATIONSHIPSHEAD;
    private final static String DOCHEAD;
    private final static String RELATIONPATT;
    private final static String DOCTAIL;
    private final static String RELATIONSHIPSTAIL;

    static {

        imagePool = ImagePool.getThepool();
        DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

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
        DOCHEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<w:document xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:w15=\"http://schemas.microsoft.com/office/word/2012/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 w15 wp14\"><w:body>";

        DOCTAIL = " \n" +
                "<w:sectPr w:rsidR=\"00D320F1\"><w:pgSz w:w=\"11906\" w:h=\"16838\"/><w:pgMar w:top=\"1440\" w:right=\"1800\" w:bottom=\"1440\" w:left=\"1800\" w:header=\"851\" w:footer=\"992\" w:gutter=\"0\"/><w:cols w:space=\"425\"/><w:docGrid w:type=\"lines\" w:linePitch=\"312\"/></w:sectPr></w:body></w:document>";

        RELATIONPATT = "<Relationship Target=\"%s\" " +
                "Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Id=\"%s\"/>";

        IMAGEPATT = "<w:p w:rsidR=\"00DC4272\" w:rsidRPr=\"00DC4272\" w:rsidRDefault=\"00DC4272\">\n" +
                "    <w:pPr>\n" +
                "        <w:ind w:left=\"420\"/>\n" +
                "        <w:rPr>\n" +
                "            <w:rFonts w:ascii=\"微软雅黑\" w:eastAsia=\"微软雅黑\" w:hAnsi=\"微软雅黑\" w:hint=\"eastAsia\"/>\n" +
                "            <w:sz w:val=\"24\"/>\n" +
                "            <w:szCs w:val=\"24\"/>\n" +
                "        </w:rPr>\n" +
                "    </w:pPr>\n" +
                "    <w:r>\n" +
                "        <w:drawing>\n" +
                "            <wp:inline distT=\"0\" distB=\"0\" distL=\"0\" distR=\"0\">\n" +
                "                <wp:extent cx=\"{0}\" cy=\"{1}\"/>\n" +
                "                <wp:effectExtent l=\"0\" t=\"0\" r=\"1270\" b=\"3810\"/>\n" +
                "                <wp:docPr id=\"{2}\" name=\"图片 1\"/>\n" +
                "                <wp:cNvGraphicFramePr>\n" +
                "                    <a:graphicFrameLocks xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" noChangeAspect=\"1\"/>\n" +
                "                </wp:cNvGraphicFramePr>\n" +
                "                <a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">\n" +
                "                    <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">\n" +
                "                        <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">\n" +
                "                            <pic:nvPicPr>\n" +
                "                                <pic:cNvPr id=\"{2}\" name=\"{3}\"/>\n" +
                "                                <pic:cNvPicPr/>\n" +
                "                            </pic:nvPicPr>\n" +
                "                            <pic:blipFill>\n" +
                "                                <a:blip r:embed=\"{2}\" cstate=\"print\">\n" +
                "                                    <a:extLst>\n" +
                "                                        <a:ext uri=\"'{28A0092B-C50C-407E-A947-70E740481C1C}'\">\n" +
                "                                            <a14:useLocalDpi xmlns:a14=\"http://schemas.microsoft.com/office/drawing/2010/main\" val=\"0\"/>\n" +
                "                                        </a:ext>\n" +
                "                                    </a:extLst>\n" +
                "                                </a:blip>\n" +
                "                                <a:stretch>\n" +
                "                                    <a:fillRect/>\n" +
                "                                </a:stretch>\n" +
                "                            </pic:blipFill>\n" +
                "                            <pic:spPr>\n" +
                "                                <a:xfrm>\n" +
                "                                    <a:off x=\"0\" y=\"0\"/>\n" +
                "                                    <a:ext cx=\"{0}\" cy=\"{1}\"/>\n" +
                "                                </a:xfrm>\n" +
                "                                <a:prstGeom prst=\"rect\">\n" +
                "                                    <a:avLst/>\n" +
                "                                </a:prstGeom>\n" +
                "                            </pic:spPr>\n" +
                "                        </pic:pic>\n" +
                "                    </a:graphicData>\n" +
                "                </a:graphic>\n" +
                "            </wp:inline>\n" +
                "        </w:drawing>\n" +
                "    </w:r>\n" +
                "    <w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>\n" +
                "    <w:bookmarkEnd w:id=\"0\"/>\n" +
                "</w:p>";
        RELATIONSHIPSHEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "\n" +
                "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n" +
                "\n" +
                "<Relationship Target=\"webSettings.xml\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings\" Id=\"rId3\"/>\n" +
                "\n" +
                "<Relationship Target=\"settings.xml\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings\" Id=\"rId2\"/>\n" +
                "\n" +
                "<Relationship Target=\"styles.xml\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles\" Id=\"rId1\"/>\n" +
                "\n" +
                "<Relationship Target=\"theme/theme1.xml\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme\" Id=\"rId6\"/>\n" +
                "\n" +
                "<Relationship Target=\"fontTable.xml\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable\" Id=\"rId5\"/>";

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
                "        <w:t>";
        HEADCON = "</w:t>\n" +
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
        HEADTAI = "</w:t>\n" +
                "    </w:r>\n" +
                "</w:p>";
        RELATIONSHIPSTAIL = "</Relationships>";
    }

    private String outputfilepath;
    private Chatroom chatroom;
    private int id = 10086;
    private StringBuilder allxmlcontant;
    private ZipArchiveOutputStream outfile;
    private ZipFile in;

    private void init() throws IOException {
        allxmlcontant = new StringBuilder(chatroom.getMessages().size() * 1000);//todo
        in = new ZipFile("data/in/in.docx");
    }
    private void putHeadXml(@NotNull BaseMessage message){
        formatHead(DATE_FORMAT.format(message.getTime()),
                "");//TODO
    }
    private String getTextXml(@NotNull TextMessage message){
        return  String.format(TEXTPATT,message.getContent().replaceAll("&#[\\d]+",""));

    }
    private void addTextMessage(TextMessage message){
        putHeadXml(message);
        addParagraph(getTextXml(message));
    }
    @Nullable
    private String getImagePath(@NotNull ImageMessage message){

        /*
        long id =message.getMsgSvrId();
        Image image =imagePool.getBigImageFromMsgid(id);

        if(image==null){
            image =imagePool.getThumbnaImageByMd5(message.getMd5());
            if(image==null){
                return null;
            }
        }
        return image.getPath();*/
        return null;
    }
    private StringBuilder relationshipsXml =new StringBuilder();
    @NotNull
    private String copyImageFile(String filepath) throws IOException {
        File file = new File(filepath);

        outfile.putArchiveEntry(new ZipArchiveEntry("word/media/"+file.getName()));
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
        IOUtils.copy(stream,outfile);
        outfile.closeArchiveEntry();
        return file.getName();
    }
    private void addRelationships(String id,String filepath) throws IOException {
        String filename=copyImageFile(filepath);
        relationshipsXml.append(formatRelation(id,filename));
    }
    private String formatRelation(String id,String filename){
        return String.format(RELATIONPATT,"media/"+filename,id);
    }
    @NotNull
    private String newId(){
        id++;
        return "rId"+id;
    }
    private void getAllMessageXml() throws IOException {
        for (BaseMessage msg : chatroom.getMessages()) {
            if (msg instanceof TextMessage) {
                addTextMessage((TextMessage) msg);
                continue;
            }

            if (msg instanceof ImageMessage) {
                addImageMessage((ImageMessage) msg);
                continue;
            }

            //todo
        }
    }
    private void addImageMessage(ImageMessage message) throws IOException {
        String imagepath=getImagePath(message);
        if (imagepath == null) {
            putHeadXml(message);
            return;
        }
        putHeadXml(message);
        String id=newId();
        addRelationships(id,imagepath);
        double imageProportion = getImageProportion(imagepath);
        if(imageProportion<1){
            addParagraph(formatImageMessage((int) (maxHeight*imageProportion),
               maxHeight,id,new File(imagepath).getName()));
        }else{
            addParagraph(formatImageMessage(maxWidth,
                    (int) (maxWidth*imageProportion),id,new File(imagepath).getName()));
        }

    }
    @NotNull
    private String  formatImageMessage(int x, int y, String id, String filename){
        return MessageFormat.format(IMAGEPATT,""+x,""+y,""+id, ""+filename);
    }
    private void addParagraph(String pxml){

        allxmlcontant.append(pxml);
    }
    private void initDocx() throws IOException {
        outfile= new ZipArchiveOutputStream( new BufferedOutputStream(
                new FileOutputStream(outputfilepath)));
        copyZipFile();
    }
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
        writeDocument();
        writeRelationShip();
        //todo
        outfile.flush();
        outfile.close();
        in.close();

    }
    private void writeDocument() throws IOException {

        outfile.putArchiveEntry(new ZipArchiveEntry("word/document.xml"));

        outfile.write(DOCHEAD.getBytes("utf-8"));
        outfile.write(allxmlcontant.toString().getBytes("utf-8"));
        outfile.write(DOCTAIL.getBytes("utf-8"));
        outfile.closeArchiveEntry();
    }
    private void writeRelationShip() throws IOException {
        outfile.putArchiveEntry(new ZipArchiveEntry("word/_rels/document.xml.rels"));
        outfile.write(RELATIONSHIPSHEAD.getBytes("utf-8"));
        outfile.write(relationshipsXml.toString().getBytes("utf-8"));
        outfile.write(RELATIONSHIPSTAIL.getBytes("utf-8"));
        outfile.closeArchiveEntry();
    }
    private void formatHead(String format, String talkerName) {
        allxmlcontant.append(HEADHEAD);
        allxmlcontant.append(format);
        allxmlcontant.append(HEADCON);
        allxmlcontant.append(talkerName);
        allxmlcontant.append(HEADTAI);
    }
    private double getImageProportion(String imagepath) {
        String suffix = "jpg";
        Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
        int width = 0, height = 0;
        if (iter.hasNext()) {
            ImageReader reader = iter.next();
            try {
                ImageInputStream stream = new FileImageInputStream(new File(
                        imagepath));
                reader.setInput(stream);
                width = reader.getWidth(reader.getMinIndex());
                height = reader.getHeight(reader.getMinIndex());

            } catch (IIOException e) {
                //todo
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                reader.dispose();
            }
        }
        return (0.0 + width) / height;
    }
}
