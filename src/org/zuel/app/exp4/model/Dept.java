package org.zuel.app.exp4.model;

public class Dept {
    //科室类;
    //属性；
    private int id;
    private int type;       //0为门诊,1为住院；
    private String name;
    private String remark;

    //各个属性的getter和setter方法;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
