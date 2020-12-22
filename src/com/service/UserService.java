package com.service;

import com.bean.User;
import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;

public class UserService {

    //掉用数据持久层UserDao
    private UserDao userDao = new UserDaoImpl();
    //通过持久层查询学号和密码
    public User findByCodeAndPass(String loginCode, String passWord) {
        return userDao.findByCodeAndPass(loginCode,passWord);
    }
}
