package com.dao.Impl;

import com.bean.Build;
import com.bean.User;
import com.dao.BuildDao;
import com.dao.UserDao;
import com.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildDaoImpl implements BuildDao {

    /**
     * 查询宿舍楼名字是否已经存在
     * @param build_name
     * @return
     */
    @Override
    public Build findByName(String build_name) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            con = ConnectionFactory.getConnection();
            //2.准备sql语句
            String sql = "select * from build where buildName = ?";
            //3.准备Preparedstatement对象用于发送sql语句
            pst = con.prepareStatement(sql);
            pst.setString(1,build_name);
            //4.执行sql语句
            rs = pst.executeQuery();

            while (rs.next()){
                Build build = new Build();
                build.setBuildId(rs.getInt("buildId"));
                build.setBuildName(rs.getString("buildName"));
                build.setRemarks(rs.getString("remarks"));

                return build;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，释放空间
            ConnectionFactory.closeCon(con,pst,rs);
        }
        return null;
    }

    /**
     * 添加新的宿舍楼
     * @param build1
     */
    @Override
    public void saveBuild(Build build1) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            con = ConnectionFactory.getConnection();
            //2.准备sql语句
            String sql = "insert into build(buildName,remarks) values (?,?)";
            //3.准备Preparedstatement对象用于发送sql语句
            pst = con.prepareStatement(sql);
            pst.setString(1,build1.getBuildName());
            pst.setString(2,build1.getRemarks());
            //4.执行sql语句
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，释放空间
            ConnectionFactory.closeCon(con,pst,rs);
        }
    }

    @Override
    public List<Build> findAllBuild() {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            con = ConnectionFactory.getConnection();
            //2.准备sql语句
            String sql = "select * from build";
            //3.准备Preparedstatement对象用于发送sql语句
            pst = con.prepareStatement(sql);
            //4.执行sql语句
            rs = pst.executeQuery();

            List<Build> builds = new ArrayList<>();
            while (rs.next()){
                Build build = new Build();
                build.setBuildId(rs.getInt("buildId"));
                build.setBuildName(rs.getString("buildName"));
                build.setRemarks(rs.getString("remarks"));

                builds.add(build);
            }
            return builds;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，释放空间
            ConnectionFactory.closeCon(con,pst,rs);
        }
        return null;
    }
}
