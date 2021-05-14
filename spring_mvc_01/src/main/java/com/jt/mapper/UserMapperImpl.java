package com.jt.mapper;

import com.jt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper{

    @Override
    public void addUser(User user) {
        System.out.println("接收的用户是:"+user);
    }
}
