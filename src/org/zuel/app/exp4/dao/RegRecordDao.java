package org.zuel.app.exp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.zuel.app.exp4.model.RegRecord;
import org.zuel.app.myutils.DbUtil;

public class RegRecordDao {
    // RegRecordDao实现对reg_record表的操作;
    // insertRegRecord()增加数据;
    public static void insertRegRecord(int id, int patient_id, int dept_id, String reg_time, double price) {
        // reg_time格式为yyyy-MM-dd HH:mm:ss;
        try {
            // 定义插入数据的sql语句;
            final String sql = "INSERT INTO reg_record VALUES(?,?,?,?,?)";
            // 创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            // 设置preparedstatement的参数;
            pst.setInt(1, id);
            pst.setInt(2, patient_id);
            pst.setInt(3, dept_id);
            pst.setString(4, reg_time);
            pst.setDouble(5, price);
            // 执行语句;
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("Insertion complete.");
            } else {
                System.out.println("Insertion failed.");
            }
            // 关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    public static void insertRegRecord(RegRecord reg) {
        // 根据对象插入数据;
        try {
            // 定义插入数据的sql语句;
            final String sql = "INSERT INTO reg_record VALUES(?,?,?,?,?)";
            // 创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            // 设置preparedstatement的参数;
            pst.setInt(1, reg.getId());
            pst.setInt(2, reg.getPatientId());
            pst.setInt(3, reg.getDeptId());
            pst.setString(4, reg.getRegTime());
            pst.setDouble(5, reg.getPrice());
            // 执行语句;
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("Insertion complete.");
            } else {
                System.out.println("Insertion failed.");
            }
            // 关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    // deleteRegRecord()删除数据;
    public static void deleteRegRecord(int id) {
        // 根据id删除挂号记录;
        try {
            // 定义删除数据的sql语句;
            final String sql = "DELETE FROM reg_record WHERE id=?";
            // 创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            // 设置preparedstatement的参数;
            pst.setInt(1, id);
            // 执行语句;
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("Deletion complete.");
            } else {
                System.out.println("Deletion failed.");
            }
            // 关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    // updateRegrecord()修改数据;
    public static void updateRegRecord(int id, double price) {
        // 根据挂号记录id修改price;
        try {
            // 定义修改数据的sql语句;
            final String sql = "UPDATE reg_record SET price=? WHERE id=?";
            // 创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            // 设置preparedstatement的参数;
            pst.setDouble(1, price);
            pst.setInt(2, id);
            // 执行语句;
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("Update complete.");
            } else {
                System.out.println("Update failed.");
            }
            // 关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    public static void updateRegRecord(int id, int dept_id) {
        // overload:根据挂号记录id修改科室id;
        try {
            // 定义修改数据的sql语句;
            final String sql = "UPDATE reg_record SET dept_id=? WHERE id=?";
            // 创建connection和statement;
            Connection conn = DbUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            // 设置preparedstatement的参数;
            pst.setInt(1, dept_id);
            pst.setInt(2, id);
            // 执行语句;
            int rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("Update complete.");
            } else {
                System.out.println("Update failed.");
            }
            // 关闭连接和statement;
            DbUtil.close(pst, conn);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }

    // execute()方法用于执行查询的sql语句;
    public static List<RegRecord> execute(String sql) throws SQLException, ParseException {
        List<RegRecord> reglist = new ArrayList<>();
        RegRecord reg;
        //创建连接、statement和resultset;
        Connection conn = DbUtil.getConn();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //将结果集存放到reglist集合中;
        while (rs.next()) {
            reg = new RegRecord();
            reg.setId(rs.getInt("id"));
            reg.setPatientId(rs.getInt("patient_id"));
            reg.setDeptId(rs.getInt("dept_id"));
            reg.setRegTime(rs.getString("reg_time"));
            reg.setPrice(rs.getDouble("price"));
            reglist.add(reg);
        }
        //关闭资源;
        DbUtil.close(rs, pst, conn);
        return reglist;
    }

    //getRegRecord()查询所有挂号记录;
    public static List<RegRecord> getRegRecord(Integer id,Integer patient_id,Integer dept_id,String reg_time) {
        //查询所有挂号记录并返回一个RegRecord集合;
        List<RegRecord> reglist = new ArrayList<>();
        try {
            //定义查询语句：
            String sql = "SELECT r.id as id,p.id as patient_id,d.id as dept_id,"
                        +"r.reg_time as reg_time,r.price as price "
                        +"FROM reg_record r left join patient p on r.patient_id=p.id "
                        +"left join dept d on r.dept_id=d.id "
                        +"WHERE 1=1 ";
            if(id!=null) {
                sql+=" and id="+id;
            }
            if(patient_id!=null) {
                sql+=" and patient_id="+patient_id;
            }
            if(dept_id!=null) {
                sql+=" and dept_id="+dept_id;
            }
            if(reg_time!=null) {
                sql+=" and reg_time= '"+reg_time+"'";
            }
            reglist = execute(sql);  
        } catch (Exception e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        return reglist;
    }

}
