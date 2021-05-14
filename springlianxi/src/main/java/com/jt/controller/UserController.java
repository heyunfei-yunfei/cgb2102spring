package com.jt.controller;

import com.jt.pojo.AxiosUser;
import com.jt.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @GetMapping("/hello")
    public String axios(){
        return "axios异步请求";
    }

    @GetMapping("/axios")
    public String axiosUser(Integer id){
        System.out.println("id为"+id);
        return "动态数据"+id;
    }

    @GetMapping("/axios01/{id}")
    public String axiosRestFul(@PathVariable Integer id){
        return "restFul接收参数"+id;
    }
    @PostMapping("/axiosParams")
    public AxiosUser axiosParams(@RequestBody AxiosUser axiosUser){
        return axiosUser;
    }




}
