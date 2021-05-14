package com.jt;

import com.jt.congig.SpringConfig;
import com.jt.pojo.User;
import com.jt.proxy.JDKProxy;
import com.jt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("白景琦");
        user.setId(3);
        userService.addUser(user);

    }
    @Test
    public void test02(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService target = (UserService) context.getBean("target");
        UserService proxy = (UserService) JDKProxy.getProxy(target);

        User user = new User();
        user.setId(108);
        user.setName("JDK动态代理完成");
       proxy.addUser(user);
        //动态代理对方法进行优化
        //删除用户的方法
       
    }
}
