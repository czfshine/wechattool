package cn.czfshine.wechat.msg.xmlmsg;

import cn.czfshine.wechat.database.DatabaseDamagedException;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.msg.MSGTYPE;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import cn.czfshine.wechat.msg.XmlMessage;
import org.dom4j.Element;

import java.sql.SQLException;
import java.util.List;

public class GroupMessage extends XmlMessage {
    public final MSGTYPE TYPE;


    private String inviterNickname;
    private String inviterUsername;

    private String memberNickname;
    private String memberUsername;

    private String newGroupName;

    public GroupMessage(MessageDO messageDO) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        super(messageDO);
        TYPE = MSGTYPE.getType(messageDO.getType());
        init();
    }

    private void init() {
        String temp = document.getRootElement().element("sysmsgtemplate")
                .element("content_template").element("template").getText();
        if(temp.contains("$remark$")){
            List<Element> elements = document.getRootElement().element("sysmsgtemplate")
                    .element("content_template").element("link_list").elements();
            for (Element e:elements
            ) {
                String name = e.attribute("name").getValue();
                if(name.equals("username")){
                    Element member = e.element("memberlist").element("member");
                    String username = member.element("username").getText();
                    String nickname = member.element("nickname").getText();
                    inviterUsername=username;
                    inviterNickname=nickname;
                }else{
                    newGroupName = e.element("plain").getText();
                }
            }
        }else if(temp.contains("$others$")){
            List<Element> elements = document.getRootElement().element("sysmsgtemplate")
                    .element("content_template").element("link_list").elements();
            for (Element e:elements
            ) {
                String name = e.attribute("name").getValue();
                if (name.equals("username")) {
                    Element member = e.element("memberlist").element("member");
                    String username = member.element("username").getText();
                    String nickname = member.element("nickname").getText();
                    inviterUsername = username;
                    inviterNickname = nickname;
                }
            }
        }else if(temp.contains("$names")&&!temp.contains("$revoke")){
            List<Element> elements = document.getRootElement().element("sysmsgtemplate")
                    .element("content_template").element("link_list").elements();
            for (Element e:elements
            ) {
                String name = e.attribute("name").getValue();
                Element member = e.element("memberlist").element("member");
                String username = member.element("username").getText();
                String nickname = member.element("nickname").getText();
                if(name.equals("username")){
                    inviterUsername=username;
                    inviterNickname=nickname;
                }else{
                    memberNickname=nickname;
                    memberUsername=username;
                }
            }
        }else{
            //todo

        }

    }

}
