package cn.czfshine.wechat.output;

import cn.czfshine.wechat.msg.Message;

import java.text.SimpleDateFormat;

/**
 * @author:czfshine
 * @date:2018/2/23 17:09
 */

public interface PlainTextable {
    public String toPlainText();

    default String getHead(Message msg){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return  String.format("%s     [%s]:",format1.format(msg.getTime()),msg.getTalker());

    };
}
