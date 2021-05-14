package com.jt.pojo;

public class User {
    private String conn;//数据库连接
    //实例化对象
    public User() {
        System.out.println("创建对象");
    }
    //2.初始化方法
    public void init(){
    this.conn = "赋值数据连接";
        System.out.println(this.conn);
    }
    //用户调用方法
    public void say(){
        System.out.println("我是用户");
    }
    //销毁资源
    public void destroy(){
        this.conn=null;
        System.out.println("释放资源:"+this.conn+"******");
    }

}
