package cn.czfshine.wechat.database;

import cn.czfshine.wechat.msg.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:czfshine
 * @date:2018/9/22 19:28
 */

public class DataBase {

    private List<MsgDataBase> msgDataBases;
    private static  Logger logger;
    static {
        logger = LoggerFactory.getLogger("Database");
    }
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
        MergeAllMesage();
    }

    public List<BaseMessage> getAllMessage(){
        return allMessage;
    }

    private MsgDataBase readMsgDB(String path) throws SQLException, IOException, ClassNotFoundException {
        String DBFILEEXT = "db";
        if(path.endsWith(DBFILEEXT)){
            return new MsgDataBase(path);
        }else{
            return MsgDataBase.buildFromFile(path);
        }
    }

    private List<BaseMessage> allMessage;
    private void MergeAllMesage(){
        logger.info("开始合并数据库：");
        List<BaseMessage> res=new ArrayList<>();
        for(MsgDataBase db : msgDataBases){
            res=MergeMessageList(res,db.getMessages());
        }
        allMessage=res;
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

}
