package org.zuel.app.exp4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.RegRecord;

public class RegQuery {
    //按不同维度条件查询挂号记录;
    public static void main(String[] args) {
        //查询挂号记录并展示;
        //rList用于存放查询结果;
        List<RegRecord> rList = new ArrayList<>();
        //使用Dao查询挂号记录数据;
        RegRecordDao rDao = new RegRecordDao();
        //查询所有挂号记录并输出;
        rList = rDao.getRegRecord();
        Iterator<RegRecord> iter = rList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
        //查询指定日期的挂号记录并输出;
        rList = rDao.getRegRecord("2020-11-11");
        iter = rList.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next.toString());
        }
        //查询指定病人id的挂号记录并输出;
        rList = rDao.getPatientRecord(3);
        ListUtil.outputList(rList);
        //查询指定科室id的挂号记录;
        rList = rDao.getDeptRecord(2);
        ListUtil.outputList(rList);
    }
}
