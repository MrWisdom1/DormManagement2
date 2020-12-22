package com.dao.Impl;

import com.bean.User;
import com.dao.UserDao;
import com.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByCodeAndPass(String loginCode, String passWord) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            con = ConnectionFactory.getConnection();
            //2.准备sql语句
            String sql = "select * from user where (userCode = ? and password = ?)";
            //3.准备Preparedstatement对象用于发送sql语句
            pst = con.prepareStatement(sql);
            pst.setString(1,loginCode);
            pst.setString(2,passWord);
            //4.执行sql语句
            rs = pst.executeQuery();

            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserCode(rs.getString("userCode"));
                user.setPassword(rs.getString("password"));
                user.setUserSex(rs.getString("userSex"));
                user.setUserTel(rs.getString("userTel"));
                user.setDormCode(rs.getInt("dormCode"));
                user.setBuildId(rs.getInt("buildId"));
                user.setRate(rs.getDouble("rate"));
                user.setUserRole(rs.getInt("userRole"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，释放空间
            ConnectionFactory.closeCon(con,pst,rs);
        }
        return null;
    }
}
