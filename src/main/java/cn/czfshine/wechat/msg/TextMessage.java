package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.output.PlainTextable;
import com.sun.deploy.uitoolkit.ui.ConsoleHelper;

import java.io.Console;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:czfshine
 * @date:2018/2/20 22:47
 */

public class TextMessage extends Message implements PlainTextable,Serializable {
    private String content;
    public static final MSGTYPE TYPE=MSGTYPE.TYPE_MSG;
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
        sb.append("文本长度"+content.length());
        content=content.replaceAll("\013","");//todo !  !!!!!
        sb.append(content.replaceAll("\n","\n\t"));

        return sb.toString();
    }
}
