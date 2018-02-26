package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.output.Docxable;
import cn.czfshine.wechat.output.PlainTextable;
import com.sun.deploy.uitoolkit.ui.ConsoleHelper;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.Console;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/20 22:47
 */

public class TextMessage extends Message implements PlainTextable,Serializable,Docxable {
    private static final long serialVersionUID = -7223261076407562700L;
    private String content;


    public static final MSGTYPE TYPE = MSGTYPE.TYPE_MSG;

    public TextMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        init(rs);
    }

    public TextMessage(long msgSvrId, long datastamp, String talker, String chatroom, String content) {
        super(msgSvrId, datastamp, talker, chatroom);
        this.content = content;
    }

    private void init(ResultSet rs) throws SQLException, DatabaseDamagedException {
        content=rs.getString("content");
        if(!talker.equals("me")){
            if(chatroom.endsWith("@chatroom")){
                talker = content.substring(0,content.indexOf(":"));
                content=content.substring(content.indexOf(":")+2);
            }
        }
    }
    @Override
    public String toString(){
        return String.format("[msg]%s - %s:%s",time.getTime(),talker,content);
    }

    @Override
    public String toPlainText() {
        StringBuilder sb=new StringBuilder();
        sb.append(getHead(this));
        sb.append("\n\t");
        sb.append(content.replaceAll("\n","\n\t"));

        return sb.toString();
    }

    @Override
    public String getDocxxml() {
        String patt="<w:p " +
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
                "\t\t<w:t>\"%s\"</w:t>\n" +
                "\t</w:r>\n" +
                "</w:p>";
        return  String.format(patt,StringEscapeUtils.escapeXml11(content).replaceAll("&#[\\d]+",""));

    }
}
