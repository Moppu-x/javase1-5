package org.zuel.app.exp4.model;

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
}
