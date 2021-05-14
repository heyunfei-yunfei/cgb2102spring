package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//使用VUE的方式 实现用户的CURD操作
@RestController
@CrossOrigin//默认条件是*,支持任意访问
public class AxiosUserController {
    @Autowired
    private UserService userService;
    //1.查询数据库用户列表数据
    //2.url:/axiosUser/findAll
    //3.返回值结果:List<User>
    @GetMapping("/axiosUser/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    @PutMapping("/axiosUser/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    //业务需求:删除用户信息
    //参数:id=1
    //返回值:void
    @DeleteMapping("/axiosUser/deleteUser")
    public void deleteUser(Integer id){
        userService.deleteUser(id);
    }
}
