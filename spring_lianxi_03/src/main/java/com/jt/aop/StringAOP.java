package com.jt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StringAOP {
    @Pointcut("@annotation(com.jt.anno.ZhuJie)")
    public void pointcut(){
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("这是环绕通知");
        Object result = null;
        try {
            System.out.println("环绕通知开始");
             result = joinPoint.proceed();
            System.out.println("环绕通知结束");
            System.out.println("这是目标方法的返回值"+result);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知回滚");
        }


    }

}
