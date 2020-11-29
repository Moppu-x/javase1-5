package org.zuel.app.exp4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zuel.app.exp4.dao.DoctorDao;
import org.zuel.app.exp4.dao.PatientDao;
import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.Doctor;
import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.model.RegRecord;

public class DoctorService {
    // login()方法用于医生登录(获取对应数据);
    public static Doctor login(int id, String password) {
        Doctor doctor = null;
        // doctor表中查询对应id和password的doctor数据;
        List<Doctor> dlist = DoctorDao.getDoctor(id, null, null, null, password);
        if (dlist.size() > 0) {
            doctor = dlist.get(0);
        }
        return doctor;
    }

    // getRecord()查询挂号记录;
    public static List<RegRecord> getRecord(Doctor doctor) {
        List<RegRecord> rlist = new ArrayList<>();
        // 获取doctor的dept_id对应的挂号记录;
        rlist = RegRecordDao.getRegRecord(null, null, doctor.getDeptId(), null);
        return rlist;
    }

    // showPatient()方法显示病人列表;
    public static void showPatient(List<RegRecord> rList) {
        Patient patient;
        Iterator<RegRecord> iter = rList.iterator();
        // 根据挂号记录的patient_id查询patient,并存放到map中
        Map<Integer,Patient> map = new HashMap<>();
        while (iter.hasNext()) {
            patient = PatientDao.getPatient(iter.next().getPatientId(), null, null, null, null).get(0);
            map.put(patient.getId(), patient);
        }
        //输出病人列表
        for(Integer key : map.keySet()) {
            System.out.println(map.get(key).toString());
        }
        System.out.println();
    }

    // 挂号记录集合中对指定时间的记录进行统计;
    public static void limitTime(List<RegRecord> rList, String time) {
        Iterator<RegRecord> iter = rList.iterator();
        RegRecord record;
        System.out.println("Registration records in "+time+": ");
        while (iter.hasNext()) {
            record=iter.next();
            if (record.getRegTime().substring(0, 10).equals(time)) {
                System.out.println(record.toString());
            }
        }
        System.out.println();
    }
}
