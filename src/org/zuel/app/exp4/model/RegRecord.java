package org.zuel.app.exp4.model;

import java.util.Scanner;

public class RegRecord {
    //挂号记录类;
    //属性;
    private int id;
    private int patient_id;
    private int dept_id;
    private String reg_time;
    private double price;

    ////各个属性的getter和setter方法;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPatientId() {
        return patient_id;
    }
    public void setPatienttId(int patient_id) {
        this.patient_id = patient_id;
    }
    public int getDeptId() {
        return dept_id;
    }
    public void setDeptId(int dept_id) {
        this.dept_id = dept_id;
    }
    public String getRegTime() {
        return reg_time;
    }
    public void setRegTime(String reg_time) {
        this.reg_time = reg_time;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //setAll()方法设置所有属性;
    public void setAll() {
        //获取输入并赋值;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the attributes of reg record");
        System.out.print("id: ");
        setId(input.nextInt());
        System.out.print("patient id: ");
        setPatienttId(input.nextInt());
        System.out.print("department id: ");
        setDeptId(input.nextInt());
        System.out.print("reg time: ");
        setRegTime(input.nextLine());
        System.out.println("price: ");
        setPrice(input.nextDouble());
        System.out.println("Inputs for reg record done.");
        input.close();
    }
}
