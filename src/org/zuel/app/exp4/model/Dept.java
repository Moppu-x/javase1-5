package org.zuel.app.exp4.model;

import java.util.Scanner;

public class Dept {
    //科室类;
    //属性；
    private int id;
    private int type;       //0为门诊,1为住院；
    private String name;
    private String remark;

    public Dept() {}
    public Dept(int id,String name,int type,String remark) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.remark = remark;
    }

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

    //setAll()方法获取输入并赋值给各个属性;
    public void setAll(Scanner input) {
        System.out.println("Input the attributes of department");
        System.out.print("id: ");
        setId(input.nextInt());
        System.out.print("type: ");
        setType(input.nextInt());
        System.out.print("name: ");
        setName(input.next());
        System.out.print("remark: ");
        setRemark(input.nextLine());
        System.out.println("Inputs for department done.");
    }

    //重写toString()方法;
    public String toString() {
        return "Department: id: "+id+" name: "+name+" type: "+type+" remark: "+remark;
    }
}
