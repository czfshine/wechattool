package cn.czfshine.wechat.example

import cn.czfshine.wechat.contant.ChatroomFactory
import cn.czfshine.wechat.contant.GroupChatroom
import cn.czfshine.wechat.contant.PersonChatroom
import cn.czfshine.wechat.contant.ServiceChatroom
import cn.czfshine.wechat.database.DataBase
import cn.czfshine.wechat.msg.ImageMessage
import cn.czfshine.wechat.msg.MessageUtils
import cn.czfshine.wechat.msg.TextMessage
import cn.czfshine.wechat.output.TextOutput
import java.io.*
import java.util.*
import java.util.stream.Collectors
import kotlin.streams.toList

/**
 * 完整用例
 *      这份代码基本上包括了整个项目的公共api，看完就会用了。
 *      同时也是我编写代码时的需求文档，只要实现里面的api，就完成代码的编写了。
 */

fun main(args: Array<String>) {

    /****数据读取********/

    //数据&资源目录
    val datadir = "/home/czfshine/workplace/wechat/data/"
    //数据库文件列表
    val files = File("$datadir//db//").listFiles { e -> e.isFile }
    //读取所有数据库(参数是一个路径数组)
    val database = DataBase(files.map { e -> e.path })


    /****数据说明****/
    //0.所有数据
    val allMessage = database.allMessage
    val allChatroom = database.allContact//todo

    //输出解析结果的统计信息
    MessageUtils.CheckMessage(allMessage);
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
    //chatroom就是你微信打开第一页里面的会话
    val chatroom = message.chatroom

    //对于所有chatroom我们可以获取
    println(chatroom.nickname)//群名或用户备注
    println(chatroom.messages.size)//消息列表

    //chatroom也分为不同类型
    when(chatroom){
        //微信群
        is GroupChatroom->{
            //一个群与其他最大不同是有群成员（按最新的数据库取成员）
            chatroom.members
            //一个群的talker是有过聊天记录的成员（可能已经退群了的）
            chatroom.talkers
        }
        //个人聊天
        is PersonChatroom-> println(chatroom.talker)
        //公众号，服务号，其他
        is ServiceChatroom -> println(chatroom.talker)

    }

    //2.2通过特定的id获取chatroom
    var username="wxid_t4dczlb6g51622";

    val chatroom1 = ChatroomFactory.getChatroom(username)

    println(chatroom1)

    //talker就是能发送消息的实体，包括用户，系统，公众号等
    //不像其他的，它没有子类，因为所有的talker基本上功能相同

    //一条消息肯定有发送方
    val talker=message.talker

    //我们可以获得如下的数据
    println(talker.username)//唯一标识符
    println(talker.nickname)//昵称
    println(talker.messages.size)

    //现在假设要获取某个群里面的某个人的所有聊天记录，可以这样
    when(chatroom){
        is GroupChatroom ->{
            chatroom.messages.stream().filter { e-> e.talker == talker }.toList()
        }
    }



    /****数据使用*****/
    //1.统计所有文本消息的长度
    var listt = (allMessage.stream()
            .filter { e -> e is TextMessage }
            .map { e -> (e as TextMessage).content }.collect(Collectors.toList()));
    var  a =OutputStreamWriter(BufferedOutputStream( File("./1.csv").outputStream()));
    for(l in listt){
        a.write(l);
        a.write("\n");
    }
    //2.使用导出器导出

    //2.1 纯文本

    //由于导出器需要一个OutputStream，先构造一个
    //会把上面chatroom1对应的聊天记录导出成纯文本，要导出所有chatroom的聊天记录遍历allChatroom就行
    //注意：消息已经按时间排序了的吧？？todo
    val fileOutputStream = FileOutputStream("./output/txt/" + chatroom1.nickname + ".txt")
    TextOutput.toTextFile(chatroom1.messages.toTypedArray(),fileOutputStream);

}