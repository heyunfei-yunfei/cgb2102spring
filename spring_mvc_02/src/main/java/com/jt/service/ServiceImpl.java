package com.jt.service;

import com.jt.anno.Find;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements DeptService{

    @Override
    @Find
    public void add() {
        System.out.println("这个类添加了find的标签");

    }
    @Find
    @Override
    public void update() {
        int i = 100%0;
        System.out.println(i);
    }
    @Find
    @Override
    public String delete(Integer id) {
        return "特洛伊木马";
    }
}
