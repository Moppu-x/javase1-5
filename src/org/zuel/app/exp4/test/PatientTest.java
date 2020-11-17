package org.zuel.app.exp4.test;

import java.util.Scanner;

import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.service.PatientService;

public class PatientTest {
    public static void main(String[] args) {
        //挂号;
        Patient patient = new Patient();
        Scanner input = new Scanner(System.in);
        System.out.print("New patient?(0-no,1-yes): ");
        int i = input.nextInt();
        switch (i) {
            case 0:
                System.out.print("id: ");
                int id = input.nextInt();
                System.out.print("password: ");
                String password = input.nextLine();
                input.close();
                patient = PatientService.login(id, password);
                break;
            case 1:
                patient = PatientService.createPatient();
                break;
            default:
                System.out.println("Input error!");
                System.exit(1);
                break;
        }
        PatientService.register(patient);
    }
}
