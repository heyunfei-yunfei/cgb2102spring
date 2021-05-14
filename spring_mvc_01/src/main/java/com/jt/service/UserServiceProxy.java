package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceProxy implements UserService {
    @Autowired
    private UserService target;
    @Override
    public void addUser(User user) {
        try{
            System.out.println("事物开始");
            target.addUser(user);
            System.out.println("事务结束");
        }catch (Exception e){
            System.out.println("事务回滚");

        }


    }
}
