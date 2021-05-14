package com.jt.mapper;

import com.jt.pojo.User;

public interface UserMapper {
    void deleteUser(User user);

    void addUser(User user);
}
