package com.jt.controller;

import com.jt.pojo.Rights;
import com.jt.pojo.User;
import com.jt.service.RightsService;
import com.jt.service.UserService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rights")
@CrossOrigin
@RestController
public class RightsController {
    @Autowired
    private RightsService rightsService;
    @GetMapping("/getRightsList")
    public SysResult getRightsList(){
       List<Rights> rightsList = rightsService.getRightsList();
        return SysResult.success(rightsList);
    }
}
