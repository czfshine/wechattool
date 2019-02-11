package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.contant.Talker;
import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;

import java.sql.SQLException;

import static cn.czfshine.wechat.msg.MSGTYPE.TYPE_YUYIN;


/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class PromptMessage extends BaseMessage {
    private String text;
    public static final MSGTYPE TYPE= TYPE_YUYIN;
    public PromptMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException {
        super(messageDO);
        init(messageDO);
    }
    private String lvbufferToString(String buf){
        byte[] bytes = buf.getBytes();
        int len=bytes[7]*256+bytes[8];//todo:长度很长的情况
        int strlen=Math.min(len,bytes.length-9);
        strlen=strlen<0? 0:strlen;
        byte[] out=new byte[strlen];

        for(int i=0;i<strlen;i++){
            out[i]=bytes[i+9];
        }
        return new String(out);

    }
    public void init(MessageDO messageDO) throws SQLException {
        text=messageDO.getContent();
        talker= Talker.getInstance("system");
        String lvbuffer = messageDO.getLvbuffer();

        if(lvbuffer!=null)
        lvbuffer=lvbufferToString(lvbuffer);
        else
            lvbuffer="";
        switch (messageDO.getType()){
            case 64: //语音
                text+="["+lvbuffer+"]";
                break;
            case 50://
                if(lvbuffer.length()>0) text=lvbuffer;
                break;
            case 10000:
                text+="["+lvbuffer+"]";
                break;
        }
    }

    public String getText() {
        return text;
    }
}
