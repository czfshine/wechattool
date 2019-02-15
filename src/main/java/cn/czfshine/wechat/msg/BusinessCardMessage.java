package cn.czfshine.wechat.msg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import org.dom4j.Attribute;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;

import java.sql.SQLException;

public class BusinessCardMessage extends XmlMessage {
    public final MSGTYPE TYPE;

    public String headImgUrl;
    public String nickname;
    public String userid;
    public BusinessCardMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }

    private void init() {
        if (document.getRootElement().getQName().getName().equals("msg")) {
            Attribute bigheadimgurl = document.getRootElement().attribute("bigheadimgurl");
            if (bigheadimgurl != null) {

                //1. 个人名片
                //头像
                headImgUrl = resumeXmlSymbol( document.getRootElement().attribute("bigheadimgurl").getValue());
                //昵称
                nickname = resumeXmlSymbol(document.getRootElement().attribute("nickname").getValue());
                //没有用户id(好像)
            } else {
                Attribute brandIconUrl = document.getRootElement().attribute("brandIconUrl");
                if(brandIconUrl!=null){
                    //2.公众号名片
                    headImgUrl =resumeXmlSymbol(brandIconUrl.getValue());
                    nickname = resumeXmlSymbol( document.getRootElement().attribute("nickname").getValue());
                    userid =resumeXmlSymbol( document.getRootElement().attribute("username").getValue());
                }else{
                    //3.理论上不会到这个分支的吧,没有了,如果有,就出错了:)
                    //todo: 错误处理
                    //System.out.println(1);
                }

            }
        } else {
            //4.理论上不会到这个分支的吧,没有了,如果有,就出错了:)
            //todo: 错误处理
            //System.out.println(1);
        }

    }

}
