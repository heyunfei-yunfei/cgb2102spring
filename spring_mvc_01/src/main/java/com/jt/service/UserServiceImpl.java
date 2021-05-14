package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("target")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
    userMapper.addUser(user);
    }
}
