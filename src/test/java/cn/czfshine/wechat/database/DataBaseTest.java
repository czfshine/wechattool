package cn.czfshine.wechat.database;

import cn.czfshine.wechat.msg.BaseMessage;
import cn.czfshine.wechat.msg.TextMessage;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DataBase Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class DataBaseTest {
    String datadir;

    @Before
    public void before() throws Exception {
        datadir = "D:\\wc\\data";
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: readMsgDB(String path)
     */
    @Test
    public void testReadMsgDB() throws Exception {
        File[] files = new File(datadir + "\\db\\").listFiles(e -> e.isFile());
        List<String> collect = Stream.of(files).map(e -> e.getPath()).collect(Collectors.toList());

        List<BaseMessage> allMessage = new DataBase(collect).getAllMessage();

        System.out.println(allMessage.stream()
                .filter(e->e instanceof TextMessage)
                .mapToLong(e->((TextMessage) e).getContent().length())
                .sum());

        /*FileWriter out=new FileWriter("test.csv");
        for(int i=0;i<allMessage.size();i++){
            out.write( Long.toString(allMessage.get(i).getTime()));
            out.write(",\n");
        }*/

    }

} 
