package cn.czfshine.wechat.msg;


import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.output.PlainTextable;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/20 22:47
 */

public class TextMessage extends BaseMessage implements PlainTextable,Serializable {
    private static final long serialVersionUID = -7223261076407562700L;

    public String getContent() {
        return content;
    }

    private String content;


    public static final MSGTYPE TYPE = MSGTYPE.TYPE_MSG;

    public TextMessage(ResultSet rs) throws SQLException, DatabaseDamagedException {
        super(rs);
        init(rs);
    }

    public TextMessage(long msgSvrId, long datastamp, String talker, String chatroom, String content) {
        super(msgSvrId, datastamp, talker, chatroom);
        this.content = StringEscapeUtils.escapeXml11(content);
    }

    private void init(ResultSet rs) throws SQLException, DatabaseDamagedException {
        content=rs.getString("content");
        if(!"me".equals(talker)){
            if(chatroom.endsWith("@chatroom")){
                talker = content.substring(0,content.indexOf(":"));
                content=StringEscapeUtils.escapeXml11(content.substring(content.indexOf(":")+2));
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


}
