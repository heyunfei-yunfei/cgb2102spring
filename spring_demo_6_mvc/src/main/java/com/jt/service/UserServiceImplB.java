package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class UserServiceImplB implements UserService{

    private UserDao userDao;
    @Override
    public void addUser(User user) {

    }
}
