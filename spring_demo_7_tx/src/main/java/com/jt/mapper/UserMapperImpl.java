package com.jt.mapper;

import com.jt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper {
    @Override
    public void deleteUser(User user) {
        System.out.println("删除用户:"+user);
    }

    /*事务的控制应该在那一层完成:service更好*/
    @Override
    public void addUser(User user) {
        System.out.println("用户入库:"+user);
    }
}
