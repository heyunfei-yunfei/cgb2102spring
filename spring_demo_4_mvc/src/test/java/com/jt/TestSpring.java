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
        controller.addUser();
        System.out.println("θΏθ‘ζε");
    }
}
