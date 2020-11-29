package org.zuel.app.exp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zuel.app.exp4.model.Dept;
import org.zuel.app.myutils.DbUtil;

public class DeptDao {
    //DeptDao实现对数据表dept的增删改查;
    //insertDept()方法实现数据的增加;
    public static void insertDept(int id,String name,int type,String remark) {
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO dept VALUES(?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, type);
            pst.setString(4, remark);
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
    public static void insertDept(Dept dept) {
        //根据对象插入数据;
        try {
            //定义插入数据的sql语句;
            final String sql = "INSERT INTO dept VALUES(?,?,?,?)";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setInt(1, dept.getId());
            pst.setString(2, dept.getName());
            pst.setInt(3, dept.getType());
            pst.setString(4, dept.getRemark());
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

    //deleteDept()方法实现数据的删除;
    public static void deleteDept(int id) {
        //根据id删除数据表中对应的记录;
        try {
            //定义删除数据的sql语句;
            final String sql = "DELETE FROM dept WHERE id=?";
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

    //updateDept()方法实现数据的修改;
    public static void updateDept(int id,String name) {
        //根据id修改name;
        try {
            //定义修改数据的sql语句;
            final String sql = "UPDATE dept SET name=? WHERE id=?";
            //创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            //设置preparedstatement的参数;
            pst.setString(1, name);
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

    //getDept()方法实现数据查询;
    public static List<Dept> getDept() {
        //查询数据，返回一个Dept集合;
        List<Dept> deptlist = new ArrayList<>();
        Dept dept;
        try {
            //定义查询语句：
            final String sql = "SELECT * FROM dept";
            //创建连接、statement和resultset;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            //将结果集存放到deptlist集合中;
            while (rs.next()) {
                dept = new Dept();
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                dept.setType(rs.getInt("type"));
                dept.setRemark(rs.getString("remark"));
                deptlist.add(dept);
            }
            //关闭资源;
            DbUtil.close(rs, pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        return deptlist;
    }
}
