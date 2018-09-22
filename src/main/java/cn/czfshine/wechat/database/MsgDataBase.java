package cn.czfshine.wechat.database;
import cn.czfshine.wechat.contant.*;
import cn.czfshine.wechat.image.BigImage;
import cn.czfshine.wechat.image.ImageDatabase;
import cn.czfshine.wechat.image.ImagePool;
import cn.czfshine.wechat.msg.Message;
import cn.czfshine.wechat.msg.MessageFactory;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * 用来操作微信聊天数据库，要使用解密后的数据库文件
 *
 * @author:czfshine
 * @date:2018/1/15 17:52
 */

public class MsgDataBase implements Serializable {
    private static final long serialVersionUID = 4766774527154700246L;
    private String datapath;
    private String selfid="self";
    private static  ContactInfo contactInfo;

    static {
        contactInfo=ContactInfo.getInstance();
    }
    Message[] allmsgs;
    Map<String,Contact> contacts;

    private  transient static Logger logger ;
    private  ImagePool imagePool;
    static {
        logger= LoggerFactory.getLogger("DBofmsg");

    }
    {
        imagePool=ImagePool.getThepool();
    }

    private transient ImageDatabase imageDatabase;
    private transient Connection connection;

    public MsgDataBase(String path) throws SQLException {
        datapath=path;
        connection = DriverManager.getConnection("jdbc:sqlite:"+datapath);
        init();
    }

    /**
     * 所有会话列表，包括个人会话，微信群，服务号等
     * @return
     */
    public List <Contact> getAllChatRoom(){
        List <Contact> chatrooms = new ArrayList<>(contacts.values() );
        chatrooms.sort(Comparator.comparingInt((Contact a) -> -a.getMessages().size()));
        for(Contact chatroom:chatrooms){
            chatroom.sortMessage();
            logger.debug("username{}-count{}",chatroom.getNickname(),chatroom.getMessages().size());
        }

        return chatrooms;
    }

    /**
     * 从保存的对象文件重建数据库对象
     * 因为解析数据库耗时较长，而且数据库是不变的，所以在第一次后将结果保存成文件，
     * 下一次直接调用这个函数载入数据文件即可，不必重新解析数据库
     *
     * 主要是要注意的是要重建全局的单例变量
     * @param savepath
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static MsgDataBase buildFromFile(String savepath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream
                (new FileInputStream( new File(savepath)),1024*1024));

        MsgDataBase msgDataBase = (MsgDataBase) objectInputStream.readObject();
        contactInfo.addContacts(msgDataBase.contacts);
        ImagePool.loadPool(msgDataBase.imagePool);
        objectInputStream.close();
        return msgDataBase;

    }

    /**
     * 保存对象成数据文件
     * @param savepath
     * @throws IOException
     * @see MsgDataBase#buildFromFile(String)
     *
     */
    public void save(String savepath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream
                (new FileOutputStream(new File(savepath))));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }
    private void init() throws SQLException {
        imageDatabase=new ImageDatabase(datapath);
        List<BigImage> images = imageDatabase.getBigImageInfoFromDatabase();
        for(BigImage image:images){
            imagePool.add(image);
        }
        allmsgs=getAllMsgssage();
        logger.info("一共有{}条图片消息，丢失{}张预览图",
                imagePool.getLoseThumbnailFileCount()+imagePool.getThumbnailFileCount(),
                imagePool.getLoseThumbnailFileCount());
        contacts=getAllConTact();
        popAllMessageToContact();


    }

    /* 会话信息 */
    private Map<String,Contact> getAllConTact() throws SQLException {
        logger.info("开始读取会话列表");
        Map<String,Contact> contacts=new HashMap<>();

        try (Statement statement = connection.createStatement()) {
            Logger logger = LoggerFactory.getLogger("DBofmsg");

            ResultSet rs = statement.executeQuery(
                    "SELECT username,alias,conRemark,nickname,type,verifyFlag,contactLabelIds FROM rcontact");

            while (rs.next()) {

                String username = rs.getString("username");
                String nickname = rs.getString("nickname");


                if (username.endsWith("@chatroom")) { //微信群
                    contacts.put(username, new GroupContact(username, nickname));
                } else if (username.startsWith("gh_")) { //服务号
                    contacts.put(username, new ServiceContact(username, nickname));
                } else { //其他的假设是个人聊天
                    String alias = rs.getString("alias");
                    String conRemark = rs.getString("conRemark");
                    String contactLabelIds = rs.getString("contactLabelIds");
                    contacts.put(username, new PersonContact(username, nickname, alias, conRemark, contactLabelIds));
                }
            }

            logger.info("一共有{}个用户信息", contacts.size());
            statement.close();
        }
        return contacts;
    }
    private Message[] getAllMsgssage() throws SQLException {
        logger.info("开始读取聊天记录");

        long startTime=System.nanoTime();
        int count=0;
        ArrayList<Message> msgs=new ArrayList<>();

        Message[] res;
        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT  msgSvrId,type,isSend,createTime,talker,content,imgPath  FROM message ");

            while (rs.next()) {
                count++;
                try {
                    Message msg = parseMsgRow(rs);
                    if (msg != null) {
                        logger.debug(msg.toString());
                        msgs.add(msg);
                        longMessageMap.put(rs.getLong("msgSvrId"), msg);
                    }
                } catch (DatabaseDamagedException e) {
                    logger.warn("在数据库{}第{}条消息损坏", datapath, "" + count);
                } catch (UnknowMassageTypeException w) {
                    logger.warn("类型{}未知，内容为：{}\n\t", rs.getString("type"), rs.getString("content"));
                } catch (Exception e) {
                    logger.error("在数据库{}第{}条消息出错", datapath, "" + count);
                    throw e;
                }

            }

            logger.info("共读取{}条记录，解析成功{}条记录", count, msgs.size());

            long endTime = System.nanoTime();
            logger.info("读取解析耗时{}纳秒", endTime - startTime);

            res = new Message[msgs.size()];

            statement.close();
        }
        return msgs.toArray(res);


    }



    private Message parseMsgRow(ResultSet rs) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        return MessageFactory.getMessage(rs);
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
    private void getSelf(){
        //TODO
    }

    private Map<Long,Message> longMessageMap=new HashMap<>();
    public Message getMsgFromMsgId(long id){
        return longMessageMap.getOrDefault(id,null);
    }

}