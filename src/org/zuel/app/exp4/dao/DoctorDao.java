package org.zuel.app.exp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zuel.app.exp4.model.Doctor;
import org.zuel.app.myutils.DbUtil;

public class DoctorDao {
    //DoctorDao实现对数据表doctor的操作;
    //insertDoctor()增加数据;
    public void insertDoctor(int id,String name,int dept_id,int sex,String password) {
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO doctor VALUES(?,?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, dept_id);
            pst.setInt(4, sex);
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
    public void insertDoctor(Doctor doctor) {
        //根据对象插入数据;
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO doctor VALUES(?,?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, doctor.getId());
            pst.setString(2, doctor.getName());
            pst.setInt(3, doctor.getDeptId());
            pst.setInt(4, doctor.getSex());
            pst.setString(5, doctor.getPassword());
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

    //deleteDoctor()删除数据;
    public void deleteDoctor(int id) {
        //根据id删除doctor表中对应的记录;
        try {
            //定义删除数据的sql语句;
            final String sql = "DELETE FROM doctor WHERE id=?";
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

    //updateDoctor()修改数据;
    public void updateDoctor(int id,int dept_id) {
        //根据id修改dept_id;
        try {
            //定义修改数据的sql语句;
            final String sql = "UPDATE doctor SET dept_id=? WHERE id=?";
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
    public void updateDoctor(int id,String password) {
        //根据id修改password;
        try {
            //定义修改数据的sql语句;
            final String sql = "UPDATE doctor SET password=? WHERE id=?";
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

    //execute()用于执行查询的sql语句;
    private List<Doctor> execute(String sql) throws SQLException {
        List<Doctor> doctorlist = new ArrayList<>();
        Doctor doctor;
        //创建连接、statement和resultset;
        Connection conn = DbUtil.getConn();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //将结果集存放到doctorlist集合中;
        while (rs.next()) {
            doctor = new Doctor();
            doctor.setId(rs.getInt("id"));
            doctor.setName(rs.getString("name"));
            doctor.setDeptId(rs.getInt("dept_id"));
            doctor.setSex(rs.getInt("sex"));
            doctor.setPassword(rs.getString("password"));
            doctorlist.add(doctor);
        }
        //关闭资源;
        DbUtil.close(rs, pst, conn);
        return doctorlist;
    }

    //getDoctor()查询所有doctor数据;
    public List<Doctor> getDoctor(Integer id,Integer sex,Integer dept_id,String name,String password) {
        //查询doctor表所有数据并返回一个Doctor集合;
        List<Doctor> doctorlist = new ArrayList<>();
        try {
            //定义查询语句：
            String sql = "SELECT t.id as id,t.name as name,d.id as dept_id,"
                              +"t.sex as sex,t.password as password FROM doctor t left join dept d "
                              +"on t.dept_id=d.id WHERE 1=1";
            if(id!=null) {
                sql+=" and t.id="+id;
            }
            if(sex!=null) {
                sql+=" and t.sex="+sex;
            }
            if(dept_id!=null) {
                sql+=" and dept_id="+dept_id;
            }
            if(name!=null) {
                sql+=" and name= '"+name+"' ";
            }
            if(password!=null) {
                sql+=" and password= '"+password+"' ";
            }
            doctorlist = execute(sql);
            System.out.println("Query complete.");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        return doctorlist;
    }

}
