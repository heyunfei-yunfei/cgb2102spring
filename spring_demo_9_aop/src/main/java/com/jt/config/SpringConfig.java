package com.jt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.jt")
@EnableAspectJAutoProxy(proxyTargetClass = false)//启动AOP注解 创建代理对象
                        //默认启动JDK动态代理,
                        //目标对象没有实现接口时,则采用CGLib代理
                        //@EnableAspectJAutoProxy(proxyTargetClass = true)//强制使用cglib proxyTargetClass=true
                        //JDK代理创建速度快,运行时稍慢，而CGLIB创建时速度较慢,运行时更快
public class SpringConfig {
}
