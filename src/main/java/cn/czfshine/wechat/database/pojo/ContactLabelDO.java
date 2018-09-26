package cn.czfshine.wechat.database.pojo;
import org.nutz.dao.entity.annotation.*;

@Table("ContactLabel")
public class ContactLabelDO {


    @Id
    private int labelID;

    @Column
    private String labelName;

    public int getLabelID() {
        return labelID;
    }

    public void setLabelID(int labelID) {
        this.labelID = labelID;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public String toString() {
        return "ContactLabelDO{" +
                "labelID=" + labelID +
                ", labelName='" + labelName + '\'' +
                '}';
    }
}