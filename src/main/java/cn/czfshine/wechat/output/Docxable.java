package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.Message;
import org.apache.commons.lang3.StringEscapeUtils;

import java.text.SimpleDateFormat;

/**
 * @author:czfshine
 * @date:2018/2/23 23:19
 */

public interface Docxable {
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    String getDocxxml();
    default String getDocxHead(Message msg){

        String patt="<w:p xmlns:v=\"urn:schemas-microsoft-com:vml \"\n" +
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
                "        <w:t>%s</w:t>\n" +
                "    </w:r>\n" +
                "    <w:r w:rsidRPr=\"00386596\">\n" +
                "        <w:rPr>\n" +
                "            <w:b/>\n" +
                "            <w:sz w:val=\"32\"/>\n" +
                "            <w:szCs w:val=\"32\"/>\n" +
                "            <w:highlight w:val=\"green\"/>\n" +
                "            <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "        </w:rPr>\n" +
                "        <w:t>%s</w:t>\n" +
                "    </w:r>\n" +
                "</w:p>";

        String res = String.format(patt, DATE_FORMAT.format(msg.getTime()),
                StringEscapeUtils.unescapeXml(msg.getTalkerName()));
        return res;
    }
}
