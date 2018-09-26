package cn.czfshine.wechat.msg;


import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.output.PlainTextable;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.Serializable;
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

    public TextMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }
    private void init(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        content= messageDO.getContent();

        content=setTalker(content);
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
