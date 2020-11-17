package org.zuel.app.exp4.service;

import java.util.Scanner;

import org.zuel.app.exp4.dao.PatientDao;
import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.model.RegRecord;

public class PatientService {
    //register()方法用于挂号;
    public static void register(Patient patient) {
        PatientDao pDao = new PatientDao();
        RegRecordDao rDao = new RegRecordDao();
        //patient表中写入病人数据;
        pDao.insertPatient(patient);
        RegRecord record = new RegRecord();
        record.setPatientId(patient.getId());
        Scanner input = new Scanner(System.in);
        System.out.print("department id: ");
        record.setDeptId(input.nextInt());
        System.out.print("registration time(format:YYYY-MM-DD HH:MM:SS): ");
        record.setRegTime(input.nextLine());
        System.out.println("price: ");
        record.setPrice(input.nextDouble());
        input.close();
        //向reg_record表写入新数据;
        rDao.insertRegRecord(record);
        System.out.println("Registration complete.");
    } 

}
