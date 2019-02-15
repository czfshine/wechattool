package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;
import org.dom4j.Attribute;

import java.sql.SQLException;

public class XmlLinkMessage extends XmlMessage {
    public final MSGTYPE TYPE;

    //标题
    private String title;
    private String url;
    private String filemd5;
    public XmlLinkMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }

    private void init() {
        title=document.getRootElement().element("appmsg").element("title").getText();//一定有,没有就是bug:)
        String text = document.getRootElement().element("appmsg").element("type").getText();

        switch (text){
            case "5":
                //推文
                url=document.getRootElement().element("appmsg").element("url").getText();//一定有,没有就是bug:)
                break;
            case  "33":
                //小程序
                //todo ??
                break;
            case "6":
                //文件
                try{
                    filemd5=document.getRootElement().element("appmsg").element("md5").getText();
                }catch (Exception e){
                    filemd5=null;
                }
                break;
            case "36":
                //小游戏 or 游戏 ??
                //todo
                break;

                default:
                    break;//没有其他的 todo

        }
        //System.out.println(text);

    }
}
