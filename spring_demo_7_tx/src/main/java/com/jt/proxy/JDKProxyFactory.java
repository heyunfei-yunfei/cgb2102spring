package com.jt.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class JDKProxyFactory {//能否利用一个工厂动态为目标对象创建代理

    //要求用户传递目标对象
    //关于匿名内部类用法说明:匿名内部类引用外部参数 要求参数必须(final Object target)
    public static Object getProxy( Object target) {
        //调用java API实现动态代理
        /*
         * 参数分析:3个参数
         * 1.ClassLoader loader(类加载器(获取目标对象的class类型))
         * 2.类<?>[] interfaces,JDK代理要求 必须有接口  java中可以多实现
         * 3.InvocationHandler h  对目标方法进行扩展*/

        //1.获取类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //2.获取接口数组
        Class[] interfaces = target.getClass().getInterfaces();
        //3.创建代理对象

        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            //invoke方法:代理对象调用方法时invoke执行,扩展方法的编辑位置
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                Object result=null;
                try{
                    //添加事务的控制
                    System.out.println("事务开始");
                    //执行目标方法
                    // target真实的目标对象,method方法对象,args方法的参数
                    result = method.invoke(target, args);
                    System.out.println("事务提交");
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("事务回滚");
                }
                //添加事务的控制

                return result;
            }
        });
        return proxy;

    }




}
