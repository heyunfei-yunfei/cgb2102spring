package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.RightsMapper;
import com.jt.pojo.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {
    @Autowired
    private RightsMapper rightsMapper;

    @Override
    public List<Rights> getRightsList() {
        QueryWrapper<Rights> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", 0);
        List<Rights> oneList = rightsMapper.selectList(wrapper);

        for (Rights rights: oneList){
             wrapper.clear();
             wrapper.eq("parent_id", rights.getId());
             List<Rights> twoList = rightsMapper.selectList(wrapper);
             rights.setChildren(twoList);
        }
        return oneList;
    }
}
