package com.jt.service;

import com.jt.anno.ZhuJie;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements UserService {
    @Override
    public void add() {

    }

    @Override
    public void update(String name, Integer id) {

    }

    @Override
    public Integer delete( String id) {
        return 128;
    }

    @Override
    @ZhuJie
    public String select() {
        return "飞雪连天射白鹿笑书神侠倚碧鸳";
    }
}
