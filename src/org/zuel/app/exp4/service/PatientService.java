package org.zuel.app.exp4.service;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.zuel.app.exp4.dao.PatientDao;
import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.model.RegRecord;

public class PatientService {
    // register()方法用于挂号;
    public static void register(Patient patient, Scanner in) throws ParseException {
        RegRecord record = new RegRecord();
        record.setPatientId(patient.getId());
        System.out.print("department id: ");
        record.setDeptId(in.nextInt());
        //获取当前时间作为挂号时间
        Date date = new Date();
        record.setRegTime(date);
        //获取挂号时间的小时数以判断挂号费
        SimpleDateFormat formater = new SimpleDateFormat("HH");
        Integer hour = Integer.valueOf(formater.format(date));
        //分时段收费，非工作时间收费较高
        if (hour<8 || hour>18) {
            record.setPrice(15);   
        } else {
            record.setPrice(10);
        }
        //向reg_record表写入新数据;
        RegRecordDao.insertRegRecord(record);
        System.out.println("Registration complete.");
    } 

    //login()方法用于已有病人登录;
    public static Patient login(int id,String password) {
        Patient patient = null;
        List<Patient> pList = PatientDao.getPatient(id, null, null, null, password);
        if(pList.size()>0){
            patient = pList.get(0);
        }
        System.out.println("Successfully login.");
        return patient;
    }

    //createPatient()方法用于新建Patient对象并写入数据库;
    public static Patient createPatient(Scanner in) {
        Patient patient = new Patient();
        patient.setAll(in);
        PatientDao.insertPatient(patient);
        List<Patient> p = 
        PatientDao.getPatient(null, patient.getName(), patient.getSex(), patient.getAge(), patient.getPassword());
        patient = p.get(0);
        System.out.println("Your id is: "+patient.getId());
        return patient;
    }
}
