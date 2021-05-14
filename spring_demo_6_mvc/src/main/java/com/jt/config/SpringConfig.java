package com.jt.config;

import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //标识我是一个配置类 相当于application.xml
//设定包扫描的路径
@ComponentScan("com.jt")//如果注解中只有value属性 则可以省略
//@PropertySource作用:加载指定的prop配置文件 将数据保存到Spring容器中
//encoding:指定字符集编码格式
@PropertySource(value = "classpath:/user.properties",encoding = "utf8")
public class SpringConfig {
    //定义对象属性 准备接收数据
    //@Value(123) 将123的值赋值给Id

    @Value("${user.id}")  //在Spring容器中查找key=user.id的数据 通过${}语法获取
    private Integer id;
    @Value("${user.username}")
    private String username;
    /*Spring <bean id="方法名" class="返回值类型"/>
     执行@Bean的方法 将方法名称当做ID,返回值的对象当做value
     直接保存到Map集合中
    *  */
    @Bean
    public User user() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

}
