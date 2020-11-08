package org.zuel.app.exp4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.RegRecord;

public class RegQuery {
    public static void main(String[] args) {
        //查询挂号记录并展示;
        //rList用于存放查询结果;
        List<RegRecord> rList = new ArrayList<>();
        //使用Dao查询挂号记录数据;
        RegRecordDao rDao = new RegRecordDao();
        rList = rDao.getRegRecord();
        Iterator<RegRecord> iter = rList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }
}
