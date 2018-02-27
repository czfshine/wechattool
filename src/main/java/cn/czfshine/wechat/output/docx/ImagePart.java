package cn.czfshine.wechat.output.docx;

import cn.czfshine.wechat.image.Image;
import cn.czfshine.wechat.image.ImagePool;
import cn.czfshine.wechat.msg.ImageMessage;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;

/**
 * https://msdn.microsoft.com/en-us/library/office/documentformat.openxml.drawing.pictures.picture.aspx
 * @author:czfshine
 * @date:2018/2/26 19:12
 */

public class ImagePart {
    String patt="<w:p w:rsidR=\"00DC4272\" w:rsidRPr=\"00DC4272\" w:rsidRDefault=\"00DC4272\">\n" +
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
            "                                <a:blip r:embed=\"rId10{2}\" cstate=\"print\">\n" +
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


    private int x;
    private int y; //~~3600000
    private String imagefilename;
    private static  int id=0;
    private String format(){
        return MessageFormat.format(patt,""+x,""+y,""+id, ""+imagefilename);
    }

    ImagePool imagePool=ImagePool.getThepool();

    private String getExt(String type){
        if(type=="+JPGE"){
            return "jpg";
        }else{
           if( type=="png"){
               return "png";
           }
        }
        return "jpg";
    }

    private void SetImagefilename(String filename){
        this.imagefilename=filename;
    }
    private void addImageFile(ZipArchiveOutputStream docxfile,Image image) throws IOException {

        File file = new File(image.getPath());
        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
        ImageReader next = imageReaders.next();

        String filename=file.getName()+"."+getExt(next.getFormatName());
        SetImagefilename(filename);
        docxfile.putArchiveEntry(new ZipArchiveEntry("word/media/"+filename));
        IOUtils.copy(new BufferedInputStream(new FileInputStream(file)),docxfile);
        docxfile.closeArchiveEntry();
    }
    private void setImagenvPicPr(Image image) throws IOException {
        BufferedImage img = ImageIO.read(new File(image.getPath()));

        int x = (int) (3600000.0 * ((img.getWidth()+0.0) / img.getHeight()));
        this.x=x;
        this.y=3600000;
        id++;
        Relationships.append(String.format("<Relationship Target=\"%s\" " +
                "Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Id=\"rId10%s\"/>","media/"+imagefilename,id));

    }
    private Image getImage(ImageMessage message) throws IOException {
        long id =message.getMsgSvrId();
       Image image =imagePool.getBigImageFromMsgid(id);

        if(image==null){
            image =imagePool.getThumbnaImageByMd5(message.getMd5());
            if(image==null){

                return null;
            }
        }


        return image;

    }

    public String getDocxXml(ImageMessage message,ZipArchiveOutputStream docxfile) throws IOException {
        Image image = getImage(message);
        addImageFile(docxfile,image);
        setImagenvPicPr(image);
        return format();
    }

    public static  String  RelationshipsHead="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"true\"?>\n" +
            "\n" +
            "-<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n" +
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
   public static  String  RelationshipsTail="</Relationships>";
    public static  StringBuilder Relationships=new StringBuilder();


}
