package org.zuel.app.exp4.test;


import java.util.Scanner;

import org.zuel.app.exp4.model.Patient;

public class RegTest {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        Patient p = new Patient();
        p.setAll(input);
        System.out.println(p.toString());
    }
}
