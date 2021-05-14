package com.jt.service;

public interface DeptService {
    void addDept();
    void updateDept();
    String after(Integer id);
    //测试异常通知
    void afterThrow();
    //测试环绕通知的执行
    void doAround();

}
