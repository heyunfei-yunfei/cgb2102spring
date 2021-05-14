package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//以后不需要再次编辑单个@Mapper,开启包扫描
@MapperScan("com.jt.mapper")
public class SpringbootDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo2Application.class, args);
    }

}
