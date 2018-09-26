package cn.czfshine.wechat.database;

import cn.czfshine.wechat.contant.*;
import cn.czfshine.wechat.database.pojo.ContactLabelDO;
import cn.czfshine.wechat.database.pojo.MessageDO;
import cn.czfshine.wechat.database.pojo.RContactDO;
import cn.czfshine.wechat.image.ImagePool;
import cn.czfshine.wechat.msg.BaseMessage;
import cn.czfshine.wechat.msg.MessageFactory;
import cn.czfshine.wechat.msg.UnknowMassageTypeException;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 用来操作微信聊天数据库，要使用解密后的数据库文件
 *
 * @author:czfshine
 * @date:2018/1/15 17:52
 */

public class MsgDataBase implements Serializable {
    private static final long serialVersionUID = 4766774527154700246L;
    private transient static Logger logger;

    static {
        logger = LoggerFactory.getLogger("DBofmsg");

    }

    private List<BaseMessage> allmsgs;
    private Map<String, Chatroom> contacts;
    private Map<String, Talker>   senders;
    private Map<Integer,String> labels;
    public List<BaseMessage> getAllMessages() {

        return allmsgs;
    }

    /**
     * 所有会话列表，包括个人会话，微信群，服务号等
     *
     * @return
     */
    public List<Chatroom> getAllChatRoom() {
        List<Chatroom> chatrooms = new ArrayList<>(contacts.values());
        chatrooms.sort(Comparator.comparing((a) -> a.getUid()));
        return chatrooms;
    }

    public List<Talker> getTalkers(){
        return new ArrayList<>(senders.values());
    }

    private String datapath;
    private ImagePool imagePool;
    private transient Connection connection;

    {
        imagePool = ImagePool.getThepool();
    }

    public MsgDataBase(String path) throws SQLException {
        datapath = path;
        connection = DriverManager.getConnection("jdbc:sqlite:" + datapath);
        init();

    }

    /**
     * 从保存的对象文件重建数据库对象
     * 因为解析数据库耗时较长，而且数据库是不变的，所以在第一次后将结果保存成文件，
     * 下一次直接调用这个函数载入数据文件即可，不必重新解析数据库
     * <p>
     * 主要是要注意的是要重建全局的单例变量
     *
     * @param savepath
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static MsgDataBase buildFromFile(String savepath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream
                (new FileInputStream(new File(savepath)), 1024 * 1024));

        MsgDataBase msgDataBase = (MsgDataBase) objectInputStream.readObject();
        ImagePool.loadPool(msgDataBase.imagePool);
        objectInputStream.close();
        return msgDataBase;

    }

    /**
     * 保存对象成数据文件
     *
     * @param savepath
     * @throws IOException
     * @see MsgDataBase#buildFromFile(String)
     */
    public void save(String savepath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream
                (new FileOutputStream(new File(savepath))));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    private NutDao dao;
    private void init() throws SQLException {
        SimpleDataSource simpleDataSource = new SimpleDataSource();

        simpleDataSource.setJdbcUrl("jdbc:sqlite:"+datapath);


        dao = new NutDao(simpleDataSource);
        /*
        imageDatabase=new ImageDatabase(datapath);
        List<BigImage> images = imageDatabase.getBigImageInfoFromDatabase();

        for(BigImage image:images){
            imagePool.add(image);
        }
        */
        labels=getAllLabel();
        contacts = getAllConTact();
        allmsgs = getAllMsgssage();
        /*
        logger.info("一共有{}条图片消息，丢失{}张预览图",
                imagePool.getLoseThumbnailFileCount()+imagePool.getThumbnailFileCount(),
                imagePool.getLoseThumbnailFileCount());
        */
        //popAllMessageToContact();


    }

    /*==具体解析用==*/

    private Map<Integer,String> getAllLabel(){

        Logger logger = LoggerFactory.getLogger("DBlabel");
        logger.info("开始读取标签列表");
        Map<Integer, String> label = new HashMap<>(100);

        List<ContactLabelDO> query = dao.query(ContactLabelDO.class, null);

        query.stream().peek(e->{label.put(e.getLabelID(),e.getLabelName());}).count();

        return label;


    }

    /* 会话信息，表rcontact */
    private Map<String, Chatroom> getAllConTact() throws SQLException {

        Logger logger = LoggerFactory.getLogger("DBroom");
        logger.info("开始读取会话列表");

        if ((labels == null)) labels=getAllLabel();
        List<RContactDO> query = dao.query(RContactDO.class, null);

        long count = query.stream().
                peek(e -> ChatroomFactory.getChatroom(e))
                .count();
        logger.info("一共有{}个用户信息",count);
        return ChatroomFactory.getAllChatroom();
    }

    /*所有消息，表message*/
    private List<BaseMessage> getAllMsgssage() throws SQLException {

        logger.info("开始读取聊天记录");

        long startTime = System.nanoTime();
        int count = 0;
        ArrayList<BaseMessage> msgs = new ArrayList<>();

        List<MessageDO> query = dao.query(MessageDO.class, null);

        for(MessageDO mdo:query){
            count++;

            try {
                BaseMessage msg = parseMsgRow(mdo);
                if (msg != null) {
                    logger.debug(msg.toString());
                    msgs.add(msg);
                }
            } catch (DatabaseDamagedException e) {
                logger.warn("在数据库{}第{}条消息损坏", datapath, "" + count);
            } catch (UnknowMassageTypeException w) {
                logger.warn("类型{}未知，内容为：{}\n\t", mdo.getType(), mdo.getContant());
            } catch (Exception e) {
                logger.error("在数据库{}第{}条消息出错", datapath, "" + count);
                throw e;
            }
        }
        logger.info("共读取{}条记录，解析成功{}条记录", count, msgs.size());
        long endTime = System.nanoTime();
        logger.info("读取解析耗时{}纳秒", endTime - startTime);

        msgs.sort(Comparator.comparingLong((BaseMessage m) -> m.getTime()));
        return msgs;
    }


    private BaseMessage parseMsgRow(MessageDO mdo) throws SQLException, DatabaseDamagedException, UnknowMassageTypeException {
        BaseMessage message = MessageFactory.getMessage(mdo);
        message.getTalker().addMessage(message);
        message.getChatroom().addMessage(message);
        return message;
    }

    private List<String> ParseLabels(String labelstr){
        String[] split = labelstr.split(",");
        List<String> collect = new ArrayList<String>(Arrays.asList(split).subList(1,split.length)).stream()
                .map(e -> labels.getOrDefault(Integer.parseInt(e),null))
                .filter(e->e!=null)
                .collect(Collectors.toList());
        return collect;
    }
}
