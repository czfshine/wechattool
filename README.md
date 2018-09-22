# wechattool
微信聊天记录工具，包括备份，查看，统计，处理等一系列工具


# Usage
> 参考[wechat-dump](https://github.com/ppwwyyxx/wechat-dump)提供的步骤从手机获取数据库和图片文件夹，本项目假设数据库已解密
## 目录结构
> 仅推荐
* 当前工作目录
   - data
       - db
          - 第一个数据库.db
          - 第二个数据库.db
       - image
          - image1  微信拷贝出的图片目录
             - 00
                - 00
                    0000abcdefghijkl 图片文件
                - 01
                - .....
             - 01
             - 02
             - ...
             - ff
          - image123456  微信拷贝出的图片目录
             - 00
             - 01
             - 02
             - ...
             - ff
       - output 输出目录
          - docx 
            ​        

## 基本使用

* Java版
```java
import cn.czfshine.wechat.contant.Contact;
import cn.czfshine.wechat.image.ImagePool;
import cn.czfshine.wechat.msg.ImageMessage;
import cn.czfshine.wechat.msg.BaseMessage;
import cn.czfshine.wechat.database.MsgDataBase;
import cn.czfshine.wechat.msg.TextMessage;

import java.sql.SQLException;
import java.util.List;

public class Main{
    public static void main(String [] args) throws SQLException {
        
        //修改下面的属性
        String dbpath="数据库路径";
        //建立数据库
        MsgDataBase db=new MsgDataBase(dbpath);
        //得到会话列表(已经按消息数量排序了）
        List<Contact> allChatRoom = db.getAllChatRoom();
        //取第一个会话
        Contact contact = allChatRoom.get(0);
        System.out.println("会话名称："+contact.getNickname());
        //获取信息列表（按时间排序了）
        List<Message> messages = contact.getMessages();
        Message message = messages.get(0);
        
        System.out.println(message.getTalkerName());
        System.out.println(message.getType());
        
        //不同的消息类型
        
        if(message instanceof TextMessage){
            System.out.println(((TextMessage) message).getContent());
        }
        
        if(message instanceof ImageMessage){
            String md5=((ImageMessage) message).getMd5();//图片的md5码
            ImagePool.getThepool().getThumbnaImageByMd5(md5).getPath();//获取图片路径
        }
        //其他类型........
    }
}    
```

* Kotlin版

```kotlin
fun main(args:Array<String>){
    val dataBase = MsgDataBase.buildFromFile("data/output/test1.obj")
    val chatRooms = dataBase.allChatRoom
    val messages = chatRooms[0].messages
    for(m in messages){
        if(m is TextMessage)
            println(m.content)
        if(m is ImageMessage)
  println(ImagePool.getThepool().getThumbnaImageByMd5(m.md5))
    }

}
```
## 导出docx
目前只支持文本和图片，docx的样式可在‘src/main/java/cn/czfshine/wechat/output/docx/DocxFile.java’里面修改（就是那一大串xml字符串，具体所代表的意思看微软官方的文档）
``` java
    MsgDataBase msgDataBase = new MsgDataBase("data/db/decrypted171028.db");
    List<Contact> allChatRoom = msgDataBase.getAllChatRoom();
    List<Message> messages = allChatRoom.get(0).getMessages();
    Message[] msg = new Message[messages.size()];
    DocxOutput.toDocx( messages.toArray(msg));
```

