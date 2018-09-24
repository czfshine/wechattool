package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.BaseMessage;

import java.text.SimpleDateFormat;

/**
 * @author:czfshine
 * @date:2018/2/23 17:09
 */

public interface PlainTextable {
    String toPlainText();


    default String getHead(BaseMessage msg){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return  String.format("%s     :",dateformat.format(msg.getTime()));

    };
}
