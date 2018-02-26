package cn.czfshine.wechat.output.docx;


import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;


import static org.apache.commons.compress.utils.IOUtils.copy;

/**
 * @author:czfshine
 * @date:2018/2/26 16:41
 */

public class DocxFile {

    private static String dochead="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<w:document xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:w15=\"http://schemas.microsoft.com/office/word/2012/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 w15 wp14\"><w:body>";

    private  static String doctail=" \n" +
            "<w:sectPr w:rsidR=\"00D320F1\"><w:pgSz w:w=\"11906\" w:h=\"16838\"/><w:pgMar w:top=\"1440\" w:right=\"1800\" w:bottom=\"1440\" w:left=\"1800\" w:header=\"851\" w:footer=\"992\" w:gutter=\"0\"/><w:cols w:space=\"425\"/><w:docGrid w:type=\"lines\" w:linePitch=\"312\"/></w:sectPr></w:body></w:document>";


    public static void ToDocxFile(String filename,String docxml) throws IOException {

        ZipFile in = new ZipFile("data/in/in.docx");

        ZipArchiveOutputStream append = new ZipArchiveOutputStream(
                new FileOutputStream(filename));
        Enumeration<ZipArchiveEntry> entries = in.getEntries();
        ZipArchiveEntry e;
        while(entries.hasMoreElements()){
            e=entries.nextElement();
            append.putArchiveEntry(e);

            if (!e.isDirectory()) {
                copy(in.getInputStream(e), append);
            }
            append.closeArchiveEntry();
        }

        append.putArchiveEntry(new ZipArchiveEntry("word/document.xml"));
        append.write(dochead.getBytes());
        append.write(docxml.getBytes());
        append.write(doctail.getBytes());
        append.closeArchiveEntry();
        append.flush();
        append.close();
        in.close();
    }

}
