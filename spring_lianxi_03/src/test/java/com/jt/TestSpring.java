package com.jt;

import com.jt.config.SpringConfig;
import com.jt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService se = context.getBean(UserService.class);
        se.select();
    }
}
