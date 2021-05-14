package com.jt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//控制注解的声明周期
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})//注解的作用对象
public @interface Cache {

}
