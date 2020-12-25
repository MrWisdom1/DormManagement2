package com.dao;

import com.bean.User;

public interface UserDao {
    //获取用户学工号和密码d的接口
    //建立接口可以使程序更加灵活可规范开发
    User findByCodeAndPass(String loginCode, String passWord);
}
