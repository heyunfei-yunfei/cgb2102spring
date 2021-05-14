package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)//重写了set方法
//MP框架重整
//1.如果没有添加注解的属性值,则默认以类名(DemoUser) 当做表名demo_user
@TableName("demo_user")//对象与表绑定
public class DemoUser {
    @TableId(type = IdType.AUTO)  //定义主键自增
    //@TableId(type = IdType.ASSIGN_UUID)//UUID随机hash算法几乎保证不重名
    private Integer id;
    //@TableField(value = "name",exist = true) 名称一致
    private String name;
    private Integer age;
    private String sex;
}
