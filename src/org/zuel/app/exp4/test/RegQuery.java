package org.zuel.app.exp4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.RegRecord;
import org.zuel.app.exp4.service.DoctorService;

public class RegQuery {
    //按不同维度条件查询挂号记录;
    public static void main(String[] args) {
        //查询挂号记录并展示;
        //rList用于存放查询结果;
        List<RegRecord> rList = new ArrayList<>();
        //查询所有挂号记录并输出;
        rList = RegRecordDao.getRegRecord(null, null, null, null);
        Iterator<RegRecord> iter = rList.iterator();
        System.out.println("All registration records: ");
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
        System.out.println(" ");
        //查询指定日期的挂号记录并输出;
        DoctorService.limitTime(rList, "2020-11-11");
        
        //查询指定病人id的挂号记录并输出;
        rList = RegRecordDao.getRegRecord(null, 9, null, null);
        iter = rList.iterator();
        System.out.println("Registration records of patient id 3: ");
        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
        System.out.println(" ");
        //查询指定科室id的挂号记录;
        rList = RegRecordDao.getRegRecord(null, null, 6, null);
        iter = rList.iterator();
        System.out.println("Registration records of department id 2: ");
        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
        System.out.println(" ");
    }
}
