package org.zuel.app.exp4.test;

import java.util.List;

import org.zuel.app.exp4.model.Doctor;
import org.zuel.app.exp4.model.RegRecord;
import org.zuel.app.exp4.service.DoctorService;

public class DoctorTest {
    public static void main(String[] args) {
        Doctor doctor = DoctorService.login(1, "danny");
        if (doctor!=null) {
            System.out.println("Successfully login.");
        }
        else{
            System.out.println("Failed to login.");
            System.exit(1);
        }
        List<RegRecord> rList = DoctorService.getRecord(doctor);
        DoctorService.showPatient(rList);
        DoctorService.limitTime(rList, "2020-11-11");
    }
}
