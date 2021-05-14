package com.jt;

import com.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void testSpringMVC(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserController controller = (UserController) context.getBean("userController");
        controller.addUser();
        System.out.println("运行成功");
    }
    @Test
    public void testSpringMVC1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application_annotation.xml");
        UserController controller = (UserController) context.getBean("userService");
        System.out.println(controller);
        System.out.println("运行成功");
    }
}
