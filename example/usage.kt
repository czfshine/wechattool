package cn.czfshine.wechat.example

import cn.czfshine.wechat.image.ImagePool
import cn.czfshine.wechat.msg.ImageMessage
import cn.czfshine.wechat.msg.MsgDataBase
import cn.czfshine.wechat.msg.TextMessage


fun main(args:Array<String>){
    val dataBase = MsgDataBase.buildFromFile("data/output/test1.obj")
    val chatRooms = dataBase.allChatRoom
    val messages = chatRooms[0].messages
    for(m in messages){
        if(m is TextMessage)
            println(m.content)
        if(m is ImageMessage)
            println(ImagePool.getThepool().getThumbnaImageByMd5(m.md5).path)
    }

}