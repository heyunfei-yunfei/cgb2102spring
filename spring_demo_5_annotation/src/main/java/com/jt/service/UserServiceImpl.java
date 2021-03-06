package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    /**
     * 关于注解的说明
     * 1.@Autowired:可以根据类型/属性名称进行注入 首先按照类型进行注入
     * 2.@Qualifier:如果需要按照名称进行注入,则需要额外添加@Qualifier
     * 3.@Resource(type="xxx.class",name="属性名称")
     * 关于注解补充:由于@Resource注解 是由java原生提供的,不是Spring官方的,所以不建议使用
     */
    //@Autowired
    //@Qualifier(value = "属性的名称")
    @Autowired
    private UserDao userDao;//基于Spring注入dao 面向接口编程


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
