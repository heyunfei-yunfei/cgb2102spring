package com.jt;

import com.jt.config.SpringConfig;
import com.jt.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptService service = context.getBean(DeptService.class);
        //service.add();
        service.delete(108);
        //service.update();
    }
}
