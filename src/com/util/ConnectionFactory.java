package com.util;

import java.sql.*;

public class ConnectionFactory {
    //获取连接
    public static Connection getConnection() throws SQLException {
        //注册驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dorm1?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai&&"
                + "user=root&password=111111");

        return con;
    }

    //关闭连接
    public static void closeCon(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if(con != null){
                con.close();
            }
            if(pst != null){
                pst.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
