package cn.czfshine.wechat.msg;
import cn.czfshine.wechat.msg.contant.Contact;
import cn.czfshine.wechat.msg.contant.Group;
import cn.czfshine.wechat.msg.contant.Person;
import cn.czfshine.wechat.msg.contant.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

/**
 * 用来操作微信聊天数据库，要使用解密后的数据库文件
 *
 * @author:czfshine
 * @date:2018/1/15 17:52
 */

public class MsgDataBase {
    private String datapath;
    private String selfid="self";
    Message[] allmsgs=getAllMsgssage();
    Map<String,Contact> contacts=getAllConTact();
    private void getSelf(){
        //TODO
    }
    private Connection connection;
    public MsgDataBase(String path) throws SQLException {
        datapath=path;
        init();
    }

    private void init() throws SQLException {

        connection = DriverManager.getConnection("jdbc:sqlite:"+datapath);
        popAllMessageToContact();

    }

    /* 会话信息 */
    private Map<String,Contact> getAllConTact() throws SQLException {
        Map<String,Contact> contacts=new HashMap<>();

        Statement statement = connection.createStatement();
        Logger logger = LoggerFactory.getLogger("DBofmsg");

        ResultSet rs = statement.executeQuery("SELECT username,alias,conRemark,nickname,type,verifyFlag,contactLabelIds FROM rcontact");
        int count=0;
        while (rs.next()) {
            count++;
            String username=rs.getString("username");
            String nickname=rs.getString("nickname");

            if(username.endsWith("@chatroom")){
                contacts.put(username,new Group(username,nickname));
            }else if(username.startsWith("gh_")){
                contacts.put(username,new Service(username,nickname));
            }else{
                String alias=rs.getString("alias");
                String conRemark=rs.getString("conRemark");
                String contactLabelIds=rs.getString("contactLabelIds");
                contacts.put(username,new Person(username,nickname,alias,conRemark,contactLabelIds));
            }
        }

        logger.info("一共有{}个用户信息",contacts.size());
        return contacts;
    }

    public String[] getAllChatRoom(Message[] msgs){
        Set<String> chatrooms=new HashSet<>();
        for(Message msg :msgs){
            chatrooms.add(msg.getChatroom());
        }
        String [] res=new String[chatrooms.size()];
        Logger logger = LoggerFactory.getLogger("DBofmsg");
        logger.info("一共有{}个聊天会话",res.length);
        return chatrooms.toArray(res);
    }

    private Message[] getAllMsgssage() throws SQLException {

        Statement statement = connection.createStatement();
        Logger logger = LoggerFactory.getLogger("DBofmsg");

        logger.info("开始读取聊天");
        long startTime=System.nanoTime();

        ResultSet rs = statement.executeQuery(
                "SELECT  msgSvrId,type,isSend,createTime,talker,content,imgPath  FROM message ");
        int count=0;
        ArrayList<Message> msgs=new ArrayList<>();
        while (rs.next()) {
            count++;

            try {
                Message msg=parseMsgRow(rs);
                if(msg!=null) {
                    logger.debug(msg.toString());

                    msgs.add(msg);
                }

            }catch (DatabaseDamagedException e) {
                logger.warn("在数据库{}第{}条消息损坏",datapath,""+count);
            }catch (UnknowMassageTypeException w){
                logger.warn("类型{}未知，内容为：{}\n\t",datapath,""+count,""+w.getId(),rs.getString("content"));
            }catch (Exception e){
                logger.error("在数据库{}第{}条消息出错",datapath,""+count);
                throw e;
            }

        }
        logger.info("共读取{}条记录，解析成功{}条记录",count,msgs.size());
        long endTime=System.nanoTime();

        logger.info("读取解析耗时{}纳秒",endTime-startTime);

        Message[] res=new Message[msgs.size()];
        return msgs.toArray(res);


    }

    private void popAllMessageToContact() throws SQLException {

        Logger logger=LoggerFactory.getLogger("DBmsg");
        for(Message msg:allmsgs){
            String chatroom=msg.getChatroom();
            if(contacts.containsKey(chatroom)){
                contacts.get(chatroom).addMessage(msg);
            }else{
                logger.warn("聊天室id:{}有聊天记录，但是在rcontact里面没有",chatroom);
            }
        }
    }


    private Message parseMsgRow(ResultSet rs) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        int type= rs.getInt("type");

        MSGTYPE msgtype=MSGTYPE.getType(type);

        switch (msgtype){
            case TYPE_MSG:return new TextMessage(rs);
            case TYPE_IMG:return new ImageMessage(rs);
            case TYPE_EMOJI:return new EmojiMessage(rs);
            case TYPE_SPEAK:return new AudioMessage(rs);
            case TYPE_VIDEO_FILE:
                case TYPE_WX_VIDEO:return new VideoMessage(rs);
        }

        return null;


    }
}
