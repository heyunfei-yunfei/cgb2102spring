package com.jt;

import com.jt.config.SpringConfig;
import com.jt.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Target;

public class TestSpring {
    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptService de = context.getBean(DeptService.class);
        //de.addDept();
        de.updateDept();

    }

    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptService de = context.getBean(DeptService.class);
        String result = de.after(110);
        System.out.println("返回的是"+result);

    }


    //测试异常通知
    @Test
    public void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptService de = context.getBean(DeptService.class);
        de.afterThrow();

    }

    //测试环绕通知
    @Test
    public void testAround() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptService de = context.getBean(DeptService.class);
        de.doAround();

    }
}