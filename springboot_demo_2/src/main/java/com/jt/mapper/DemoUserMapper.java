package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.DemoUser;


import java.util.List;
//注意事项: BaseMapper必须添加泛型对象 切记!!!
public interface DemoUserMapper extends BaseMapper<DemoUser> {
    List<DemoUser> findAll();

    void insertUser(DemoUser user);

    void updateUser(String oldname, String nowname, String sex);
}
