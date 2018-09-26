package cn.czfshine.wechat.example

import cn.czfshine.wechat.database.pojo.ContactLabelDO
import org.nutz.dao.impl.NutDao
import org.nutz.dao.impl.SimpleDataSource

fun main(args: Array<String>) {
    val dataSource = SimpleDataSource();
    val datapath="D:\\wc\\data\\1.db"
    dataSource.setJdbcUrl("jdbc:sqlite:$datapath");


    val dao = NutDao(dataSource)

    dao.create(ContactLabelDO::class.java,false);
    //dao.insert(T);
    var people = dao.query(ContactLabelDO::class.java,null)
    people.stream().peek{e->println((e as ContactLabelDO).labelName)}.count()
    println(people)
    people = dao.query(ContactLabelDO::class.java,null)
    people.stream().peek{e->println((e as ContactLabelDO).labelName)}.count()
    println(people)

}