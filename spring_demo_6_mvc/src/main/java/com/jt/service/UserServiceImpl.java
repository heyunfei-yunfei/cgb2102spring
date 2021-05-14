package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired//根据类型注入
    // @Qualifier("aaaa")//必须按照名称进行匹配 一般不写
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
