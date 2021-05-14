package com.jt.service;

public interface UserService {
    void add();
    void update(String name,Integer id);
    Integer delete(String id);
    String select();
}
