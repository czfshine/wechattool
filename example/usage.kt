package cn.czfshine.wechat.example

import cn.czfshine.wechat.database.DataBase
import cn.czfshine.wechat.msg.ImageMessage
import cn.czfshine.wechat.msg.TextMessage
import java.io.File

/**
 * 用例
 */

fun main(args: Array<String>) {

    /****数据读取********/

    //数据&资源目录
    val datadir = "D:\\wc\\data"
    //数据库文件列表
    val files = File("$datadir\\db\\").listFiles { e -> e.isFile }
    //读取所有数据库(参数是一个路径数组)
    val database = DataBase(files.map { e -> e.path })


    /****数据说明****/
    //0.所有数据
    val allMessage = database.allMessage
    val allChatroom = database.allContact//todo

    //1.关于消息
    val message = allMessage[0]
    //  对于一条消息，我们主要关心
    //  1.1时间
    println(message.time)
    //  1.2地点（在哪说的，某个群还是某个用户的个人聊天窗口）
    println(message.chatroom)
    //  1.3人物（谁说的）
    println(message.talker)

    //  1.4类型和内容
    //      顺带一提，kotlin的when太好用了：）
    when (message) {
        is TextMessage -> println(message.content)
        is ImageMessage -> println(message.md5)
    }

    //2 chatroom&talker


    /****数据使用*****/
    //1.统计所有文本消息的长度
    println(allMessage.stream()
            .filter { e -> e is TextMessage }
            .mapToInt { e -> (e as TextMessage).content.length }
            .sum())

}