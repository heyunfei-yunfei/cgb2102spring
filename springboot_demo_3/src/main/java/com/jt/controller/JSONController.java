package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
@RestController//@Controller+@RestController该类中所有的返回值类型都是JSON字符串
//@Controller
public class JSONController {
    /**
     * 需求:要求根据getJSON的请求,获取User对象的JSON数据.
     *用法:如果需要返回 JSON数据则使用注解@ResponseBody
     * 知识点讲解:
     * 返回的对象之后,SpringMVC通过内部API(ObjectMapper)
     * 调用对象getXXX()犯法动态的获取属性和属性值
     * 演化规则:
     * 调用get方法属性大写字母变成小写,提取属性值形成key:value的结构
     * 注意事项:必须添加get/set方法
     */
    //JSON字符串模板
    //[true,{"id":"100","name":"tomact","hobbys":["敲代码","玩游戏","找对象",
    //{"username":"user","password":"密码"}]},100]
    @RequestMapping("/getJSON")
    //@ResponseBody//返回值就是一个JSON串
    public User getJSON(){
        User user = new User();
        user.setId(108).setName("JSON测试");
        return user;
    }

}
