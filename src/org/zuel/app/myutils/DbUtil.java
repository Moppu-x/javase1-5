package org.zuel.app.myutils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

//自定义的JDBC连接工具类；
public class DbUtil {

    // 驱动、数据库URL、用户名和密码;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/exp";
    private static String user = "root";
    private static String password = "830930";

    // getConn方法用于获取连接；
    public static Connection getConn() throws SQLException {
        // 加载驱动;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //创建连接;
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    //close方法用于关闭资源;
    public static void close(ResultSet rs,PreparedStatement pst,Connection conn) throws SQLException {
        if(!rs.isClosed()) { rs.close(); }
        if(!pst.isClosed()) { pst.close(); }
        if(!conn.isClosed()) { conn.close(); }
    }
    //overload close method;
    public static void close(PreparedStatement pst,Connection conn) throws SQLException {
        close(null, pst, conn);
    }

}
