package cn.czfshine.wechat.msg;

/**
 * @author:czfshine
 * @date:2018/2/20 22:14
 */

public class UnknowMassageTypeException extends Exception    {
    public int getId() {
        return id;
    }

    private int id;
    public UnknowMassageTypeException(int typeid){
        this.id=typeid;
    }
}
