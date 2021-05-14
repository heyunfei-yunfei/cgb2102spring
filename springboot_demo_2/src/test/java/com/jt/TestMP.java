package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.DemoUserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestMP {
    @Autowired
    private DemoUserMapper userMapper;

    @Test
    public void insert() {
        DemoUser user = new DemoUser();
        user.setName("MP测试").setSex("男").setAge(20);
        userMapper.insert(user);
    }

    //测试更新操作修改id=231 的数据 name="中午吃什么" age=18

    /**
     * 原则:根据对象中不为null的属性当做set条件.set name="xxx"
     * 如果ById的操作,则Id必须赋值 并且ID当做唯一的where条件
     */
    @Test
    public void update() {
        DemoUser user = new DemoUser();
        user.setName("中午吃什么").setAge(18).setId(231);
        userMapper.updateById(user);
    }

    /*根据id查询
     * 查询name="白骨精" sex=nv 的用户 List
     * 知识点
     * 1.queryWrapper条件构造器 拼接where条件的
     *   原则 :根据对象中不为null的属性进行where条件的拼接
     *
     * */
    @Test
    public void testSelect() {
        //根据id查询
        DemoUser user = userMapper.selectById(21);
        System.out.println(user);

        //根据属性查询
        DemoUser user1 = new DemoUser();
        user1.setName("白骨精").setSex("女");
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>(user1);//条件构造器
        List<DemoUser> demoUsers = userMapper.selectList(queryWrapper);
        System.out.println(demoUsers);
    }

    //查询年龄大于18岁 并且性别为女
    //sql: select *from demp_user where age>18 and sex="女"
    // 特殊字符 > 为gt;
    @Test
    public void testselect02() {
        QueryWrapper<DemoUser> q = new QueryWrapper<>();
        q.gt("age", 18).eq("sex", "女");
        List<DemoUser> demoUsers = userMapper.selectList(q);
        System.out.println(demoUsers);
    }

    /*
     * 查询性别sex=男的数据,以id倒序排列
     * select*from demo_user where sex='男' order by id desc;
     * */
    @Test
    public void testselect03() {
        QueryWrapper<DemoUser> q = new QueryWrapper<>();
        q.eq("sex", "男").orderByDesc("id");
        List<DemoUser> demoUsers = userMapper.selectList(q);
        System.out.println(demoUsers);
    }

    /*5.查询id=1,3,5,6,7
     * select*from demo from demo_user where id in(1,3,5,7)
     * */

    @Test
    public void testselect04() {
        //数组使用包装类型
        Integer[] ids = {1, 3, 5, 6, 7};
        //需要将数组转化为集合
        List<Integer> integers = Arrays.asList(ids);
        QueryWrapper<DemoUser> q = new QueryWrapper<>();
        q.in("id", integers);//根据list查询 list集合功能丰富,数组必须包装类型
        List<DemoUser> demoUsers = userMapper.selectList(q);
        System.out.println(demoUsers);
    }

    //需求:如果根据name属性 和sex属性查询数据,有时某个数据可能为null
    //要求动态查询
    /*伪代码: sql: select*from demo_user where name!=null name=xxx age!=null age>xxx
     *
     * condition:内部编辑一个判断的条件 如果返回值为true 则拼接该字段,
     * 如果为false则不拼接该字段
     *StringUtils.hasLength(name) 判断字符串是否有效
     * */
    @Test
    public void testselect05() {
        String name = "";
        int age = 18;
        QueryWrapper<DemoUser> q = new QueryWrapper<>();
        q.eq(StringUtils.hasLength(name), "name", name).gt(age > 0, "age", age);
        List<DemoUser> demoUsers = userMapper.selectList(q);
        System.out.println(demoUsers);


    }


    //只想查询第一列数据 selecObjs
    /*说明 :queryWrapper = null 不需要where条件
    * selectObjs
    * 1.一般根据条件查询id的值 ,查询之后为后续的sql提供数据支持
    * 2.有时用户只需要查询ID的值,并不需要其他数据项这时使用objs*/
    @Test
    public void testselect06() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sex", "男");
        List objs =  userMapper.selectObjs(null);

        System.out.println(objs);

    }


    //只想查询:name/sex的字段
    /*
    * queryWrapper.select("name", "sex");  挑选指定字段
    *
    * */
    @Test
    public void testselect07() {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper();
        queryWrapper.select("name", "sex");
        List list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    //返回有效字段查询
    @Test
    public void testselect08() {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","sex");
        List<Map<String, Object>> map = userMapper.selectMaps(queryWrapper);
        System.out.println(map);
    }

    /**
     * 更新数据
     * 将name="中午吃什么" 改为 name = "晚上吃什么"
     * 性别:改为 其他
     * sql:update demo_user set name="晚上吃什么",sex = "其他" where name="中午吃什么";
     * 参数说明:
     * 1.entity 实体对象   需要修改的数据进行封装
     * 2.QueryWrapper 条件构造器
     */
    @Test
    public void testSlect10(){
        DemoUser user = new DemoUser();
        user.setName("晚上吃什么").setSex("其他");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("name", "中午吃什么" );
        userMapper.update(user,updateWrapper);
    }

}