package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /*接收ajax请求 /findAjaxUser 查询所有的用户信息
    * 返回值结果:JSON字符串*/
    @RequestMapping("/findAjaxUser")
    @ResponseBody
    public List<User> findAjaxUser(){
        return userService.findAll();
    }
    @RequestMapping("/findUser")
    @ResponseBody
    public User  selectById(Integer id){
        return userService.findById(id);

    }




    /**
     * 要求跳转到userAjax页面中
     * @return
     */
    @RequestMapping("/userAjax")
    public String  userAjax(){
        return "userAjax";
    }




    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){

        return "框架整合初步完成";
    }
    @RequestMapping("/userList")
    public String usrList(Model model){
        //查询业务层获取数据
        List<User> list = userService.findAll();
        //将数据保存到model对象中返回给页面
        model.addAttribute("userList", list);
        return "userList";
    }

    /**
     * 利用restFul实现用户数据新增
     * url:地址:/user/tom/188/女
     * 优化策略:
     *  1.如果有多个参数提交,则可以使用对象接收,但是要求
     *  参数名称必须与属性名称一致
     */
    @RequestMapping(value = "/user/{name}/{age}/{sex}")

    public String restFul(User user){
        userService.insertUser(user);


        return "redirect:/userList";
    }

    /**
     * 修改数据
     */
    @RequestMapping("/user/{id}/{name}")
    public String updateUser(User user){
        userService.updateUser(user);

        return "redirect:/userList";
    }

    //增加数据
    @RequestMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser( id);
        return "redirect:/userList";
    }

}
