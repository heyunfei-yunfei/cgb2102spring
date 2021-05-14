package com.jt.service;

import com.jt.annota.Find;
import com.jt.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    @Find
    public void findUser(User user) {
        System.out.println("从数据库中查询数据:"+user);

    }
}
