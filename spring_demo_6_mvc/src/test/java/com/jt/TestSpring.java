package com.jt;

import com.jt.config.SpringConfig;
import com.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
    }
    //通过配置类测试代码
    @Test
    public void testAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.addUser();

    }
}
