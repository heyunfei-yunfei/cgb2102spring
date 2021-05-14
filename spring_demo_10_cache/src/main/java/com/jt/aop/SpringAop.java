package com.jt.aop;

import com.jt.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class SpringAop {
    private static Map map = new HashMap();
    @Pointcut("@annotation(com.jt.annota.Find)")
    public void pointcut() {
    }

    @AfterReturning(pointcut = "pointcut()",returning = "result")
    public Object AfterFind(JoinPoint joinPoint,Object result){
        return null;
    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
            Object result =null;
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        Integer id = user.getId();
        if (map.containsKey(id)){
            System.out.println("缓存执行");
            return map.get(id);
        }else {
            System.out.println("执行目标方法");
             result = joinPoint.proceed();
             map.put(id, user);
        }

        return result;
    }


    @Test
    public void get(){
        Object o = map.get(108);
        System.out.println(o);
    }
}