package com.jt;

import com.jt.mapper.DemoUserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemo2ApplicationTests {
    //JDK动态代理对象
    @Autowired
    private DemoUserMapper userMapper;  //红线警告  :这是IDEA误报
    @Test
    void contextLoads() {
        System.out.println(userMapper.getClass());//查询是什么代理
        List<DemoUser> userList = userMapper.findAll();
        System.out.println(userList);
    }

    //新增用户
    @Test
    public void test01(){
        DemoUser user = new DemoUser();
        user.setId(null).setName("mybatis信息").setAge(18).setSex("男");

        userMapper.insertUser(user);
    }

    /**
     * 将mybatis name="mybatis信息" 改为测试信息  ,要求性别="男"
     */
    //更新操作
    @Test
    public void test02(){
       //封装数据
        String oldname = "mybatis信息";
        String nowname = "测试信息";
        String sex = "男";
        userMapper.updateUser(oldname,nowname,sex);
    }

    //测试MybatisPlus
    @Test
    public void testSelect(){
        List<DemoUser> user = userMapper.selectList(null);
        System.out.println(user);
    }

}
