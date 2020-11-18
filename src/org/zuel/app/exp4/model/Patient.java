package org.zuel.app.exp4.model;

import java.util.Scanner;

public class Patient {
    //病人类;
    //属性;
    private int id;
    private int sex;        //0表示男，1表示女;
    private int age;
    private String name;
    private String password;

    public Patient() {}
    public Patient(int id,String name,int sex,int age,String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
    }

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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
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

    //setAll()方法设置所有属性;
    public void setAll(Scanner input) {
        //获取的输入赋值给属性;
        System.out.println("Input the information of patient");
        System.out.print("id: ");
        setId(input.nextInt());
        System.out.print("name: ");
        setName(input.next());
        System.out.print("sex(0 for male, 1 for female): ");
        setSex(input.nextInt());
        System.out.print("age: ");
        setAge(input.nextInt());
        System.out.print("password: ");
        setPassword(input.next());
        System.out.println("Inputs for patient done.");
    }

    //重写toString()方法;
    public String toString() {
        return "Patient: id: "+id+" name: "+name+" sex: "+sex+" age: "+age;
    }
}
