package cn.czfshine.wechat.msg;

import java.io.Serializable;

/**
 * @author:czfshine
 * @date:2018/2/20 22:02
 */

public enum MSGTYPE implements Serializable {

    /**主要消息类型**/
    TYPE_MSG(1,TextMessage.class,"文本"),
    TYPE_SPEAK(34,AudioMessage.class,"语音"),

    TYPE_WX_VIDEO (62,VideoMessage.class,"视频") ,
    TYPE_VIDEO_FILE (43,VideoMessage.class,"视频文件"),

    TYPE_IMG (3,ImageMessage.class,"图片"),
    TYPE_EMOJI (47,EmojiMessage.class,"表情"),

    /**提示类**/
    TYPE_YUYIN(64,PromptMessage.class,"微信语音聊天"),
    TYPE_VOIP (50,PromptMessage.class),
    TYPE_SYSTEM (10000,PromptMessage.class),

    /**富文本，基于xml**/
    TYPE_NAMECARD (42,XmlMessage.class,"名片"),
    TYPE_LOCATION(48,XmlMessage.class,"位置"),
    TYPE_LINK (49,XmlMessage.class,"链接") ,
    TYPE_REDENVELOPE (436207665,XmlMessage.class),
    TYPE_LOCATION_SHARING (1879048186,XmlMessage.class),
    TYPE_LOCATION_SHARING_D( -1879048186,XmlMessage.class),//todo ？？？？？
    TYPE_YUNDONG(-1879048185,XmlMessage.class),//微信运动日提示
    TYPE_YUNDONG_ZHAN(-1879048183,XmlMessage.class),//微信运动赞
    TYPE_GROUP_MONEY(503316529,XmlMessage.class),//群收款
    TYPE_MENRY(419430449,XmlMessage.class),//转账
    TYPE_SHEAR(268435505,XmlMessage.class),//别的应用的分享
    TYPE_APP_MSG (16777265,XmlMessage.class),
    TYPE_APP_NOTION(318767153,XmlMessage.class),//公众号应用消息

    TYPE_GROUP(10002,XmlMessage.class),//群相关的系统通知
    TYPE_APP(570425393,XmlMessage.class),
    TYPE_JUAN(452984881,XmlMessage.class),
    TYPE_CLOUD(35,XmlMessage.class),

    /**链接**/
    TYPE_MP_TUIWEN(285212721,LinkMessage.class),//公众号推文

    /*未处理*/
    //TODO
    TYPE_CUSTOM_EMOJI (1048625, CustomEmojiMessage.class),

    TYPE_UNKNOW(-1,UnknownMessage.class);
    public  final int id;

    private String typename="";
    public Class getClazz() {
        return clazz;
    }

    private Class clazz;
    MSGTYPE(int typeid, Class cl){
        id=typeid;
        clazz=cl;
    }

    MSGTYPE(int typeid, Class cl ,String typename){
        id=typeid;
        clazz=cl;
        this.typename=typename;
    }

    public static MSGTYPE getType(int typeid) throws UnknowMassageTypeException {
        for(MSGTYPE t:MSGTYPE.values()){
            if(t.id==typeid){
                return t;
            }
        }
        return TYPE_UNKNOW;
    }

    @Override
    public String toString() {
        if(!"".equals(typename)) {
            return typename;
        }
        return "无名类型"+id;
    }

}
