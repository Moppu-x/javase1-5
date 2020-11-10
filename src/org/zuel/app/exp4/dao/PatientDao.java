package org.zuel.app.exp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zuel.app.exp4.model.Patient;
import org.zuel.app.myutils.DbUtil;

public class PatientDao {
    //PatientDao实现对数据表patient的增删改查;
    //insertPatient()增加数据;
    public void insertPatient(int id,String name,int sex,int age,String password) {
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO patient VALUES(?,?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, sex);
            pst.setInt(4, age);
            pst.setString(5, password);
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
    public void insertPatient(Patient patient) {
        //根据对象将记录插入数据表;
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO patient VALUES(?,?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, patient.getId());
            pst.setString(2, patient.getName());
            pst.setInt(3, patient.getSex());
            pst.setInt(4, patient.getAge());
            pst.setString(5, patient.getPassword());
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

    //deletePatient()删除数据;
    public void deletePatient(int id) {
        //根据id删除数据表中对应的记录;
        try {
            //定义删除数据的sql语句;
            final String sql = "DELETE FROM patient WHERE id=?";
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

    //updatePatient()修改password;
    public void updatePatient(int id,String password) {
        //根据id修改password;
        try {
            //定义修改数据的sql语句;
            final String sql = "UPDATE patient SET password=? WHERE id=?";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setString(1, password);
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

    //getPatient()查询所有病人数据;
    public List<Patient> getPatient() {
        //查询数据，返回一个Patient集合;
        List<Patient> patientlist = new ArrayList<>();
        Patient patient;
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM patient";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            //将结果集存放到patientlist集合中;
            while (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setSex(rs.getInt("sex"));
                patient.setAge(rs.getInt("age"));
                patient.setPassword(rs.getString("password"));
                patientlist.add(patient);
            }
            //关闭资源;
            DbUtil.close(rs, pst, conn);
            System.out.println("Query complete.");
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        return patientlist;
    }

    //getPatient(int id)查询指定id的病人数据;
    public Patient getPatient(int id) {
        //查询数据并返回一个Patient对象;
        Patient patient = new Patient();
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM patient WHERE id=?";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            //将结果处理为patient对象;
            patient.setId(rs.getInt("id"));
            patient.setName(rs.getString("name"));
            patient.setSex(rs.getInt("sex"));
            patient.setAge(rs.getInt("age"));
            patient.setPassword(rs.getString("password"));
            //关闭资源;
            DbUtil.close(rs, pst, conn);
            System.out.println("Query complete.");
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        return patient;
    }
}