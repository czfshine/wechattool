package cn.czfshine.wechat.msg;

/**
 * @author:czfshine
 * @date:2018/2/20 22:02
 */

public enum MSGTYPE {

    /*主要消息类型*/
    TYPE_MSG(1),
    TYPE_IMG (3),
    TYPE_SPEAK(34),
    TYPE_WX_VIDEO (62) ,
    TYPE_VIDEO_FILE (43),
    TYPE_EMOJI (47),

    /*提示类*/
    TYPE_YUYIN(64),//微信语音聊天

    /*未处理*/
    TYPE_NAMECARD (42),
    TYPE_LOCATION(48),
    TYPE_LINK (49) ,
    TYPE_VOIP (50),
    TYPE_SYSTEM (10000),
    TYPE_CUSTOM_EMOJI (1048625),
    TYPE_REDENVELOPE (436207665),
    TYPE_LOCATION_SHARING (1879048186),
    TYPE_LOCATION_SHARING_D( -1879048186),//todo ？？？？？
    TYPE_YUNDONG(-1879048185),//微信运动日提示
    TYPE_YUNDONG_ZHAN(-1879048183),//微信运动赞
    TYPE_GROUP_MONEY(503316529),//群收款
    TYPE_MENRY(419430449),//转账
    TYPE_SHEAR(268435505),//别的应用的分享
    TYPE_APP_MSG (16777265),
    TYPE_APP_NOTION(318767153),//公众号应用消息
    TYPE_MP_TUIWEN(285212721),//公众号推文
    TYPE_GROUP(10002);//群相关的系统通知


    private int id;
    MSGTYPE(int typeid){
        id=typeid;
    }

    public static MSGTYPE getType(int typeid) throws UnknowMassageTypeException {
        for(MSGTYPE t:MSGTYPE.values()){
            if(t.id==typeid){
                return t;
            }
        }
        throw new UnknowMassageTypeException(typeid);
    }


}
