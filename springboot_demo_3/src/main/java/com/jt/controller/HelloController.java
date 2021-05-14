package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//1.将该类交给Spring容器管理 2.同时开启SpringMVC机制
public class HelloController {

    /*需求:http://localhost:8090/hello  访问hello.html
     * 实现步骤:
     *  1.拦截用户的请求
     *  2.String 类型的返回值 表示返回页面名称
     *  3.根据yml配置文件中的内容 动态的拼接前缀和后缀 才能形成页面唯一路径
     * */
    //该方法以后使用的主流的方法
    @RequestMapping("/hello")//拦截用户客户端
    public String hello() {
        //动态的拼接前缀+后缀
        ///classpath:/templates/hello.html
        return "hello";  //有后缀
    }
    @RequestMapping("/say")
    public String say(){
        return "say";
    }


}
