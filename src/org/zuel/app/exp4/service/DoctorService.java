package org.zuel.app.exp4.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zuel.app.exp4.dao.DoctorDao;
import org.zuel.app.exp4.dao.PatientDao;
import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.Doctor;
import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.model.RegRecord;

public class DoctorService {
    //login()方法用于医生登录(获取对应数据);
    public static Doctor login(int id,String password) {
        Doctor doctor = null;
        DoctorDao dDao = new DoctorDao();
        //doctor表中查询对应id和password的doctor数据;
        List<Doctor> dl = dDao.getDoctor(id, null, null, null, password);
        if(dl.size()>0) {
            doctor = dl.get(0);
        }
        return doctor;
    }

    //getRecord()查询挂号记录;
    public static List<RegRecord> getRecord(Doctor doctor) {
        List<RegRecord> rl =new ArrayList<>();
        RegRecordDao rDao = new RegRecordDao();
        //获取doctor的dept_id对应的挂号记录;
        rl = rDao.getRegRecord(null, null, doctor.getDeptId(), null);
        return rl;
    }

    //showPatient()方法显示病人列表;
    public static void showPatient(List<RegRecord> rList) {
        Patient patient;
        PatientDao pDao = new PatientDao();
        Iterator<RegRecord> iter = rList.iterator();
        //根据挂号记录的patient_id查询patient并显示信息;
        System.out.println("Patient list: ");
        while (iter.hasNext()) {
            patient = pDao.getPatient(iter.next().getPatientId(), null, null, null, null).get(0);
            System.out.println(patient.toString());
        }
        System.out.println(" ");
    }

    //挂号记录集合中对指定时间的记录进行统计;
    public static void limitTime(List<RegRecord> rList,String time) {
        Iterator<RegRecord> iter = rList.iterator();
        RegRecord record;
        System.out.println("Registration records in "+time+": ");
        while (iter.hasNext()) {
            record=iter.next();
            if (record.getRegTime()==time) {
                System.out.println(record.toString());
            }
        }
        System.out.println(" ");
    }
}
