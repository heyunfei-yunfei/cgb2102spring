package com.jt.controller;

import com.jt.pojo.Axios;
import org.springframework.web.bind.annotation.*;

//在后端接收前端axios发来的请求
@RestController
@CrossOrigin//允许当前类中的所有方法执行跨域操作
public class AxiosController {
    /*Axios入门案例
     * url:http://localhost:8090/hello*/
    @GetMapping("/hello")
     public String hello(){
         return "Vue的Ajax异步调用";
     }

    /**
     * 1.接收get请求的Id参数
     * 'http://localhost:8090/axios?id=100
     */
    @GetMapping("/axios")
    public String getAxios(Integer id){
        return "动态获取数据:"+id;
    }
    @GetMapping("/axios/{id}")
    public String axiosRestFul(@PathVariable Integer id){
        return "restFul接收参数:"+id;
    }

    /*测试params对象数据参数

     */

    @GetMapping("/axiosParams")
    public String getAxios(Integer id,String name){
        return "params获取参数成功";
    }

    /**
     * 动态接收post请求 并且接收json参数
     * url地址:/addAxios
     * 语法:
     * 如果前端传递的是一个JSON的字符串.
     * 则使用注解@RequestBody将json串转化为对象
     */
    @PostMapping("/addAxios")
    public Axios addAxios(@RequestBody Axios axios){
        return  axios;
    }

    @PostMapping("/addAxiosForm")
    public Axios addAxiosForm(Axios axios){
        return axios;
    }


}
