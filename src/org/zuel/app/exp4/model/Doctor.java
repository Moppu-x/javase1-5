package org.zuel.app.exp4.model;

import java.util.Scanner;

public class Doctor {
    //医生类;
    //属性;
    private int id;
    private int sex;        //0表示未知,1表示男，2表示女;
    private int dept_id;
    private String name;
    private String password;

    //各个属性的getter和setter方法;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getDeptId() {
        return dept_id;
    }
    public void setDeptId(int dept_id) {
        this.dept_id = dept_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //setAll()方法获取输入并赋值给各属性;
    public void setAll() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the attributes of doctor");
        System.out.print("id: ");
        setId(input.nextInt());
        System.out.print("sex(1 for male,2 for female,0 for unknown): ");
        setSex(input.nextInt());
        System.out.print("department id: ");
        setDeptId(input.nextInt());
        System.out.print("name: ");
        setName(input.nextLine());
        System.out.println("password: ");
        setPassword(input.nextLine());
        System.out.println("Inputs for doctor done.");
        input.close();
    }

    //重写toString()方法;
    public String toString() {
        return "Doctor: id: "+id+" name: "+name+" sex: "+sex+" department id: "+dept_id;
    }
}
