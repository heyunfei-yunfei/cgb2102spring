package com.jt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static Object getProxy(Object target){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("事务提交");
                    result = method.invoke(target, args);

                } catch (Exception e) {

                }
                return result  ;
            }
        });
        return proxy;
    }
}
