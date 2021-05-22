package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@RequestMapping("/user")
@AllArgsConstructor
@NoArgsConstructor
public class SysResult {
    private Integer status ;
    private String msg;
    private Object data;

    public static SysResult fail(){
        return new SysResult(201,"服务器运行失败",null);
    }
    public static SysResult success(){
        return new SysResult(200,"服务器运行成功",null);
    }
    public static SysResult success(String msg,Object data){
        return new SysResult(200,msg,data);
    }
    public static SysResult success(Object data){
        return new SysResult(200,"服务器运行成功",data);
        }
}
