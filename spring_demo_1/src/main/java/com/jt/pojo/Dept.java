package com.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component//将对象交给Spring容器管理
//@PropertySource(value = "classpath:/dept.properties",encoding = "utf8")//加载指定配置文件
@Data   //DATA是lombok使用最多的 自动生成get/set/toString/equals/hashcode等方法
@Accessors(chain = true) //重写了set方法,返回this对象
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    //spel表达式
    @Value("${dept.id}")
    private Integer id;
    @Value("${dept.name}")
    private String name;







}
