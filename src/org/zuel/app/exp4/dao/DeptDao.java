package org.zuel.app.exp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.zuel.app.exp4.model.Dept;
import org.zuel.app.myutils.DbUtil;

public class DeptDao {
    //DeptDao实现对数据表dept的增删改查;
    //insertDept方法实现数据的增加;
    public void insertDept(int id,String name,int type,String remark) {
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

    //deleteDept方法实现数据的删除;
    public void deleteDept(int id) {
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

    public void updateDept(int id,String name) {
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

\   public List<Dept> getDept() {
        //查询数据，返回一个Dept集合;
        try {
            
        } catch (Exception e) {
            //TODO: handle exception
        }
}
}
