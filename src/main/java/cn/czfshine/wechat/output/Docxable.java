package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.Message;

import java.text.SimpleDateFormat;

/**
 * @author:czfshine
 * @date:2018/2/23 23:19
 */

public interface Docxable {

    public  String getDocxxml();
    default String getDocxHead(Message msg){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return  String.format("<w:p " +
                "xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\"" +

                " w:rsidR=\"00386596\" w:rsidRDefault=\"00386596\">\n" +
                "\t<w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r w:rsidRPr=\"00386596\">\n" +
                "\t\t<w:rPr>\n" +
                "\t\t\t<w:rFonts w:ascii=\"黑体\" w:eastAsia=\"黑体\" w:hAnsi=\"黑体\"/>\n" +
                "\t\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>%s</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r w:rsidRPr=\"00386596\">\n" +
                "\t\t<w:rPr>\n" +
                "\t\t\t<w:b/>\n" +
                "\t\t\t<w:sz w:val=\"32\"/>\n" +
                "\t\t\t<w:szCs w:val=\"32\"/>\n" +
                "\t\t\t<w:highlight w:val=\"green\"/>\n" +
                "\t\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>%s</w:t>\n" +
                "\t</w:r>\n" +
                "</w:p>",format1.format(msg.getTime()),msg.getTalker());
    };
}
