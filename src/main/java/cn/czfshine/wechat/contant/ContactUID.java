package cn.czfshine.wechat.contant;



public class ContactUID {


    private String uid;

    public ContactUID(String uid) {
        this.uid = uid;

    }

    public String getUid(){
        return uid;
    }

    public static ContactUID ME= new ContactUID("me");

    public static ContactUID SYSTEM= new ContactUID("system");

}
