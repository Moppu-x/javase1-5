package org.zuel.app.exp4.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegRecord {
    // 挂号记录类;
    private int id;
    private int patient_id;
    private int dept_id;
    private Date reg_time;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private double price;

    public RegRecord() {}
    public RegRecord(int id, int patient_id, int dept_id, Date reg_time, double price) throws ParseException {
        this.id = id;
        this.patient_id = patient_id;
        this.dept_id = dept_id;
        this.reg_time = reg_time;
        this.price = price;
    }
    
    //各个属性的getter和setter方法;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPatientId() {
        return patient_id;
    }
    public void setPatientId(int patient_id) {
        this.patient_id = patient_id;
    }
    public int getDeptId() {
        return dept_id;
    }
    public void setDeptId(int dept_id) {
        this.dept_id = dept_id;
    }
    public String getRegTime() {
        return format.format(reg_time);
    }
    public void setRegTime(String string) throws ParseException {
        this.reg_time = format.parse(string);
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //setAll()方法设置所有属性;
    public void setAll(Scanner input) throws ParseException {
        //获取输入并赋值;
        System.out.println("Input the attributes of registration record");
        System.out.print("id: ");
        setId(input.nextInt());
        System.out.print("patient id: ");
        setPatientId(input.nextInt());
        System.out.print("department id: ");
        setDeptId(input.nextInt());
        input.nextLine();
        System.out.print("registration time(format:yyyy-MM-dd hh:mm:ss): ");
        setRegTime(input.nextLine());
        input.nextLine();
        System.out.print("price: ");
        setPrice(input.nextDouble());
        System.out.println("Inputs for registration record done.");
    }

    //重写toString()方法;
    public String toString() {
        return "Registration Record: id: "+id+" patient id: "+patient_id+" department id: "+dept_id
                +" registration time: "+format.format(reg_time)+" price: "+price;
    }
}
