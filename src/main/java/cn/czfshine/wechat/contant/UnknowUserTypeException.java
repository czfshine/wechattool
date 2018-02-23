package cn.czfshine.wechat.contant;

/**
 * 未知的用户类型
 * @author:czfshine
 * @date:2018/2/21 11:59
 */

public class UnknowUserTypeException extends Exception {

    public int getTypeid() {
        return typeid;
    }

    private int typeid;
    UnknowUserTypeException(int typeid){
        this.typeid=typeid;
    }
}
