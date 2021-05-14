package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public void insertUser(User user) {
     //MP的方式实现增加
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }
}
