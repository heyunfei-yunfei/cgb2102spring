package com.jt;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    //测试方法返回值必须为void,方法名不能是类名
    @Test
    public void testSpring01() {
        //1.通过加载配置文件,创建Spring容器对象,容器创建,对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //2.从容器中获取对象,通过bean的ID获取对象
        User user = (User) context.getBean("user");
        /*User user1 = context.getBean(User.class);
        User user2 = context.getBean("user", User.class);*/
        //执行方法
        user.say();
    }
    @Test
    public void demo2()throws Exception{
        User user  = (User) Class.forName("com.jt.pojo.User").newInstance();
        user.say();
    }
}
