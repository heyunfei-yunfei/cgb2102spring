package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("target")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /*事务控制层应该放到Service层进行控制*/
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);

//
//        try {
//            System.out.println("事务开始");
//            userMapper.addUser(user);
//            System.out.println("事务的结束");
//        }catch (Exception e){
//            System.out.println("事務回滾");
//        }

    }

    @Override
    public void deleteUser(User user) {
       userMapper.deleteUser(user);
    }
}


