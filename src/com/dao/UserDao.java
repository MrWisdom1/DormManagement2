package com.dao;

import com.bean.User;

public interface UserDao {
    //获取用户学工号和密码
    User findByCodeAndPass(String loginCode, String passWord);
}
