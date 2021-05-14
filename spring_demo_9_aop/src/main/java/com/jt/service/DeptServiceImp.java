package com.jt.service;

import com.jt.anno.Cache;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImp implements DeptService {
    @Override
    public void addDept() {
        System.out.println("添加部门信息");
    }

    @Override
    @Cache
    public void updateDept() {
        System.out.println("更新部门");
    }

    @Override
    @Cache
    public String after(Integer id) {

        return "Spring通知的测试";
    }

    //让该方法执行时抛出异常
    @Override
    @Cache
    public void afterThrow() {
        System.out.println("用户执行目标方法");
        //手动抛出算数异常
        int a=1/0;
    }

    @Override
    @Cache//标识执行AOP方法
    public void doAround() {
        System.out.println("实现用户的入库操作");
    }
}
