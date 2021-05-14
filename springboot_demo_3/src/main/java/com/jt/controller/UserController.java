package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class UserController {

    /**
     * 测试转发和重定向
     * 1.关键字: forward: 转发的是一个请求....
     *          redirect:多次请求多次响应
     *   转发的特点:
     *   1.转发时 会携带用户提交的数据
     *   2:转发的意义:
     *    如果直接转向到页面中,如果页面需要额外的参数处理,则没有执行
     *    如果在该方法中添加业务处理,则方法的耦合性高. 不方便后续维护所以方法应尽可能松耦合
     *
     *    1.重定向:
     *    重定向时 由于是多次请求,所以不会携带用户的数据
     *    重定向时 由于是多次请求,所以用户的浏览器的地址会发生变化
     *
     *    5.实际意义 ;实现了方法内部的松耦合
     *    6.什么时候使用转发/什么时候使用重定向
     *     1)如果需要携带参数 使用转发
     *    2)如果一个业务已经完成需要一个新的开始 则使用重定向
     *
     * @return
     */

    @RequestMapping("/findUser")
    public String findUser(String name){
       // return "forward:/findDog";
        return "redirect:/dog"; //重定向到findDog请求
    }

    @RequestMapping("/findDog")
    public String findDog(String name , Model model){
        System.out.println("动态获取name属性值:"+name);
        model.addAttribute("name", name+"汪汪汪");
        return "dog";
    }


    @RequestMapping("/addUser")
    public String addUserDog(User user){
        System.out.println(user);
        return "success";
    }





    /**
     *使用对象的方式接受数据
     *
     * 对象赋值的原理:
     * 要求pojo对象中必须有get/set方法
     * 1.当用户提交数据之后,利用对选哪个的set方法为属性赋值
     *
     * @param user
     * @return
     */
    //@RequestMapping("/addUser")
    public String addUser(User user){

        System.out.println(user);
        return "success";
    }



    /**
     * 同名提交测试:
     * url参数:id: name: hobbies:敲代码 hobbies: 敲键盘 hobbies:敲鼠标
     * 参数提交的形式:springMVC自动的将参数进行了","号 拼接 敲代码,敲键盘,敲主机
     * SpringMVC优化:
     * 1.可以根据逗号 自动的将字符串进行拆分
     * 2.如果数据类型不是String类型,则可以自动的转化
     * 总结:如果以后遇到了同名提交问题,则使用 数组 或者 可变参数 类型接收
     * String...hobbies 可变参数类型实质就是 数组
     */

   // @RequestMapping("/addUser")
    public String addHobbies( Integer id, String name,String... hobbies){

        System.out.println("参数:"+id+":"+name+ Arrays.toString(hobbies));
        return "success";
    }



    /**
     * 页面提交的参数id:    name:
     * 测试@RequestParam注解
     * @RequestParam()参数说明
     * 1.name/value  接收参数的名称
     * 2.required  默认值 true 该数据项为必填项
     * 3.defaultValue 设定数据默认值  如果参数为null 则设定默认值
     *4 .require 与defaultValue 是互斥的
     *
     */
    //@RequestMapping("/addUser")
    public String addUserParam(@RequestParam(value = "id" , required = true,defaultValue = "108") Integer id, String name){
        System.out.println("参数:"+id+":"+name);
        return "success";
    }






    /**
     * Spring MVC赋值:
     * 内部根据request.getParameter("id")方式获取数据
     * @param id
     * @param name
     * @return
     */
   // @RequestMapping("/addUser")
    public String addUser(Integer id,String name){
        System.out.println("参数:"+id+":"+name);
        return "success";
    }



    /**
     * 请求路径http://localhost:8090/addUser
     *
     * request/response对象说明 只要用户调用就会自动的赋值
     * servlet:缺点:接收的参数都是String类型
     * @param model
     * @return
     */

//    @RequestMapping("/addUser")
//    public String addUser(HttpServletRequest request, HttpServletResponse response){
//        //利用API进行类型转化
//        int id = Integer.parseInt(request.getParameter("id"));//int 类型转化为int包装类
//        String name = request.getParameter("name");
//        System.out.println("参数:"+id+":"+name);
//        return "success";
//    }



    //简化数据传递
    @RequestMapping("/user")
    public String toUser(Model model){
        //将数据通过model进行传递
        model.addAttribute("id", 103);
        model.addAttribute("name", "SpringMVC");
        return "user";
    }



    /**
     * mvc底层数据传输原则
     * url:http://localhost:8090/user
     * ModelAndView
     * 1.model 封装数据
     * 2.View   封装视图页面的
     */
    /*@RequestMapping("/user")
    public ModelAndView toUser(){
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("id",1001);
        modelAndView.addObject("name","安其拉");
        //封装页面数据
        modelAndView.setViewName("user");
        return modelAndView;
    }*/
}
