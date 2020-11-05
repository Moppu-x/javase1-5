package org.zuel.app.exp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zuel.app.exp4.model.RegRecord;
import org.zuel.app.myutils.DbUtil;

public class RegRecordDao {
    //RegRecordDao实现对reg_record表的操作;
    //insertRegRecord()增加数据;
    public void insertRegRecord(int id,int patient_id,int dept_id,String reg_time,double price) {
        //reg_time格式为YYYY-MM-DD HH:MM:SS;
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO reg_record VALUES(?,?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            pst.setInt(2, patient_id);
            pst.setInt(3, dept_id);
            pst.setString(4, reg_time);
            pst.setDouble(5, price);
            //执行语句;
            int rs = pst.executeUpdate();
            if(rs>0){
                System.out.println("Insertion complete.");
            }
            else{
                System.out.println("Insertion failed.");
            }
            //关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    //deleteRegRecord()删除数据;
    public void deleteRegRecord(int id) {
        //根据id删除挂号记录;
        try {
            //定义删除数据的sql语句;
            final String sql = "DELETE FROM reg_record WHERE id=?";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            //执行语句;
            int rs = pst.executeUpdate();
            if(rs>0){
                System.out.println("Deletion complete.");
            }
            else{
                System.out.println("Deletion failed.");
            }
            //关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    //updateRegrecord()修改数据;
    public void updateRegRecord(int id, double price) {
        //根据挂号记录id修改price;
        try {
            //定义修改数据的sql语句;
            final String sql = "UPDATE reg_record SET price=? WHERE id=?";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setDouble(1, price);
            pst.setInt(2, id);
            //执行语句;
            int rs = pst.executeUpdate();
            if(rs>0){
                System.out.println("Update complete.");
            }
            else{
                System.out.println("Update failed.");
            }
            //关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }
    public void updateRegRecord(int id, int dept_id) {
        //overload:根据挂号记录id修改科室id;
        try {
            //定义修改数据的sql语句;
            final String sql = "UPDATE reg_record SET dept_id=? WHERE id=?";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, dept_id);
            pst.setInt(2, id);
            //执行语句;
            int rs = pst.executeUpdate();
            if(rs>0){
                System.out.println("Update complete.");
            }
            else{
                System.out.println("Update failed.");
            }
            //关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    //getRegRecord()查询所有挂号记录;
    public List<RegRecord> getRegRecord() {
        //查询所有挂号记录并返回一个RegRecord集合;
        List<RegRecord> reglist = new ArrayList<>();
        RegRecord reg;
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM reg_record";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            //将结果集存放到reglist集合中;
            while (rs.next()) {
                reg = new RegRecord();
                reg.setId(rs.getInt("id"));
                reg.setPatienttId(rs.getInt("patient_id"));
                reg.setDeptId(rs.getInt("dept_id"));
                reg.setRegTime(rs.getString("reg_time"));
                reg.setPrice(rs.getDouble("price"));
                reglist.add(reg);
            }
            //关闭资源;
            DbUtil.close(rs, pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        System.out.println("Query complete.");
        return reglist;
    }

    //getRegRecord(int id)查询指定挂号记录id的数据;
    public RegRecord getrRegRecord(int id) {
        //查询指定id的挂号记录并返回一个RegRecord对象;
        RegRecord reg = new RegRecord();
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM reg_record WHERE id=?";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            //将结果集处理为reg对象;
            reg.setId(rs.getInt("id"));
            reg.setPatienttId(rs.getInt("patient_id"));
            reg.setDeptId(rs.getInt("dept_id"));
            reg.setRegTime(rs.getString("reg_time"));
            reg.setPrice(rs.getDouble("price"));
            //关闭资源;
            DbUtil.close(rs, pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        System.out.println("Query complete.");
        return reg;
    }

    //getPatientRecord(int patient_id)查询指定病人id的挂号记录
    public List<RegRecord> getPatientRecord(int patient_id) {
        //查询指定patient_id的所有挂号记录并返回一个RegRecord集合;
        List<RegRecord> reglist = new ArrayList<>();
        RegRecord reg;
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM reg_record WHERE patient_id=?";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement参数;
            pst.setInt(1, patient_id);
            ResultSet rs = pst.executeQuery();
            //将结果集存放到reglist集合中;
            while (rs.next()) {
                reg = new RegRecord();
                reg.setId(rs.getInt("id"));
                reg.setPatienttId(rs.getInt("patient_id"));
                reg.setDeptId(rs.getInt("dept_id"));
                reg.setRegTime(rs.getString("reg_time"));
                reg.setPrice(rs.getDouble("price"));
                reglist.add(reg);
            }
            //关闭资源;
            DbUtil.close(rs, pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        System.out.println("Query complete.");
        return reglist;
    }

    //getDeptRecord(int dept_id)查询指定科室id的数据;
    public List<RegRecord> getDeptRecord(int dept_id) {
        //查询指定dept_id的所有挂号记录数据并返回一个RegRecord集合;
        List<RegRecord> reglist = new ArrayList<>();
        RegRecord reg;
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM reg_record WHERE dept_id=?";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement参数;
            pst.setInt(1, dept_id);
            ResultSet rs = pst.executeQuery();
            //将结果集存放到reglist集合中;
            while (rs.next()) {
                reg = new RegRecord();
                reg.setId(rs.getInt("id"));
                reg.setPatienttId(rs.getInt("patient_id"));
                reg.setDeptId(rs.getInt("dept_id"));
                reg.setRegTime(rs.getString("reg_time"));
                reg.setPrice(rs.getDouble("price"));
                reglist.add(reg);
            }
            //关闭资源;
            DbUtil.close(rs, pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        System.out.println("Query complete.");
        return reglist;
    }
}
