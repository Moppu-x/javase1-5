package org.zuel.app.exp4.service;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.zuel.app.exp4.dao.PatientDao;
import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.model.RegRecord;

public class PatientService {
    // register()方法用于挂号;
    public static void register(Patient patient, Scanner in) throws ParseException {
        RegRecordDao rDao = new RegRecordDao();
        RegRecord record = new RegRecord();
        record.setPatientId(patient.getId());
        System.out.print("department id: ");
        record.setDeptId(in.nextInt());
        System.out.print("registration time(format:yyyy-MM-dd hh:mm:ss): ");
        record.setRegTime(in.next());
        System.out.println("price: ");
        record.setPrice(in.nextDouble());
        //向reg_record表写入新数据;
        rDao.insertRegRecord(record);
        System.out.println("Registration complete.");
    } 

    //login()方法用于已有病人登录;
    public static Patient login(int id,String password) {
        Patient patient = null;
        PatientDao pDao = new PatientDao();
        List<Patient> pList = pDao.getPatient(id, null, null, null, password);
        if(pList.size()>0){
            patient = pList.get(0);
        }
        return patient;
    }

    //createPatient()方法用于新建Patient对象并写入数据库;
    public static Patient createPatient(Scanner in) {
        Patient patient = new Patient();
        PatientDao pDao = new PatientDao();
        patient.setAll(in);
        pDao.insertPatient(patient);
        return patient;
    }
}
