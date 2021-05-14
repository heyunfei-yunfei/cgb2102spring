package com.jt.factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class SpringFactory implements FactoryBean<Calendar> {

    //工厂模式实例化对象的方法
    @Override
    public Calendar getObject() throws Exception {
        return Calendar.getInstance();

    }


    //获取类型
    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    //默认条件下spring容器中都是 单例对象
    // 多线程问题 多例对象 安全性问题
    //多个资源对共享数据进行访问
    //对象.方法() 没有安全性问题 提倡使用单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
