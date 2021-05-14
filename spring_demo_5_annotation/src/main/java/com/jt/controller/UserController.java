package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //spring 容器负责注入Service对象
    @Autowired
    private UserService userService;


    public void addUser(){
        User user = new User();
        userService.addUser(user);
    }

   // private User user;//代替用户传入的参数
}
