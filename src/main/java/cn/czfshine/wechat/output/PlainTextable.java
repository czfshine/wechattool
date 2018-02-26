package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.Message;

import java.text.SimpleDateFormat;

/**
 * @author:czfshine
 * @date:2018/2/23 17:09
 */

public interface PlainTextable {
    public String toPlainText();

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    default String getHead(Message msg){
        return  String.format("%s     [%s]:",DATE_FORMAT.format(msg.getTime()),msg.getTalkerName());

    };
}
