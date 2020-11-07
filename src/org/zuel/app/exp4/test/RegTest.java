package org.zuel.app.exp4.test;

import org.zuel.app.exp4.dao.PatientDao;
import org.zuel.app.exp4.dao.RegRecordDao;
import org.zuel.app.exp4.model.Patient;
import org.zuel.app.exp4.model.RegRecord;

public class RegTest {
    public static void main(String[] args) {
        //模拟挂号业务并向数据库中写入记录;
        //创建一个病人对象和一个挂号记录对象;
        Patient patient = new Patient();
        RegRecord reg = new RegRecord();
        //设置patient和reg的属性;
        //使用setAll方法获取输入并赋值给patient和reg;
        patient.setAll();
        reg.setAll();
        //使用对应的Dao向数据库中写入数据;
        PatientDao pDao = new PatientDao();
        RegRecordDao rDao = new RegRecordDao();
        pDao.insertPatient(patient);
        rDao.insertRegRecord(reg);
    }
}
