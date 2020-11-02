package org.zuel.app.exp4.model;

public class Patient {
    //病人类;
    //属性;
    private int id;
    private int sex;        //0表示未知,1表示男，2表示女;
    private int age;
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
}
