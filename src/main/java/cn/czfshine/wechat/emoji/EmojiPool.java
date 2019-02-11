package cn.czfshine.wechat.emoji;

import java.util.HashMap;

public class EmojiPool {

    private static HashMap<String,Emoji> allEmoji=new HashMap<>();

    public static Emoji getEmoji(String md5){
        return allEmoji.getOrDefault(md5,null);
    }

    public static void add(String md5,Emoji emoji){
        allEmoji.put(md5,emoji);
    }
}
