package cn.czfshine.wechat.database;

import cn.czfshine.wechat.contant.Chatroom;
import cn.czfshine.wechat.contant.ChatroomFactory;
import cn.czfshine.wechat.msg.BaseMessage;
import cn.czfshine.wechat.msg.MessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @author:czfshine
 * @date:2018/9/22 19:28
 */

public class DataBase {

    private List<BaseMessage> allMessage;
    private Map<String, Chatroom> allContact;
    public DataBase(List<String> datafiles){
        logger.info("开始解析数据库：");
        msgDataBases=new LinkedList<>();
        for(String path:datafiles){
            try{
                logger.info("开始解析数据库{}：",path);
                MsgDataBase msgDataBase=readMsgDB(path);
                msgDataBases.add(msgDataBase);

            } catch (Exception e) {
                logger.error("解析数据库{}失败：",path);
                e.printStackTrace();
            }
        }
        MergeDatabases();
    }

    public List<BaseMessage> getAllMessage(){
        return allMessage;
    }
    public Map<String, Chatroom> getAllContact(){
        return allContact;
    }
    private List<MsgDataBase> msgDataBases;
    private static  Logger logger;
    static {
        logger = LoggerFactory.getLogger("Database");
    }

    private MsgDataBase readMsgDB(String path) throws SQLException, IOException, ClassNotFoundException {
        String DBFILEEXT = "db";
        if(path.endsWith(DBFILEEXT)){
            return new MsgDataBase(path);
        }else{
            return MsgDataBase.buildFromFile(path);
        }
    }


    private void MergeDatabases(){
        logger.info("开始合并数据库：");

        for(MsgDataBase db : msgDataBases){
           /* msgres=MergeMessageList(msgres,db.getMessages());
            contactMap=MergeContact(contactMap,db.getContacts());*///todo
        }

        allMessage= MessageFactory.listMessage();
        allContact= ChatroomFactory.getAllChatroom();
    }

    private List<BaseMessage> MergeMessageList(List<BaseMessage> a,List<BaseMessage> b){
        //todo:假设在一个List存在同时发送的消息，会出错，不过概率那么小（时间精确到毫秒的），考虑这种情况代码会复杂很多很多
        logger.info("合并前大小为{}和{}：",a.size(),b.size());
        List<BaseMessage> res=new ArrayList<>(a.size()+b.size());
        int i=0;
        int j=0;
        while(true){
            if(i>=a.size()){
                res.addAll(b.subList(j,b.size()-1));
                break;
            }else if(j>=b.size()){
                res.addAll(a.subList(i,a.size()-1));
                break;
            }
            if(a.get(i).getTime()<b.get(j).getTime()){
                res.add(a.get(i));
                i++;

            }else if(a.get(i).getTime()>b.get(j).getTime()){
                res.add(b.get(j));
                j++;
            }else{
                res.add(a.get(i));
                if(!a.get(i).equals(b.get(j))){
                    res.add(b.get(j));
                }

                i++;j++;
            }


        }
        logger.info("合并结果为{}",res.size());
        logger.info("重复的数量为{}",(a.size()+b.size())-res.size());
        return res;
    }


    private Map<String, Chatroom> MergeContact(final Map<String, Chatroom> a, final Map<String, Chatroom> b){
        Map<String, Chatroom> res = new HashMap<>();
        res.putAll(a);
        for(String k:b.keySet()){
            if(res.containsKey(k)){
                res.merge(k, b.get(k),(o,n)->n);
            }else{
                res.put(k, b.get(k));
            }
        }
        logger.info("合并会话消息，总数{},重复{}", res.size(), a.size() + b.size() - res.size());
        return res;
    }
}
