package com.jt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class SpringAOP {
    @Pointcut("@annotation(com.jt.anno.Find)")
    public void  pointcut(){
    }
    //@Before("pointcut()")
    public void before(){

        System.out.println("这是before通知");
    }
    //@AfterReturning(pointcut = "pointcut()",returning = "flower")
    public void AfterReturning(JoinPoint joinPoint, Object flower){
        System.out.println("这是AfterReturning通知");
        System.out.println(joinPoint.getTarget().getClass()+"这是目标对象类型");
        System.out.println(joinPoint.getSignature().getDeclaringTypeName()+"这是目标对象类名");
        System.out.println(joinPoint.getSignature().getName()+"这是目标对象方法名");
        System.out.println(Arrays.toString(joinPoint.getArgs())+"这是目标对象方法参数");
        System.out.println("目标方法的返回值是"+flower);
        System.out.println("AfterReturning通知执行完毕");
    }

    //@AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void AfterThrow(Exception e){
        System.out.println("这是抛出异常的通知,抛出的异常时"+e);

    }



    @Around("pointcut()")
    public void AroundMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知开始");
            result  = joinPoint.proceed();

        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("环绕通知回滚");
        }
        System.out.println("环绕通知的返回值是"+result);
        System.out.println("环绕通知结束");
    }
}
