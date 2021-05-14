package com.jt.pojo;

import javax.sound.midi.Soundbank;

public class User {
    //反射机制调用时,必然调用对象的无参构造,所以写构造方法一定要提供一个无参构造
    public User(){
        System.out.println("我是一个无参构造");
    }
    public void say(){
        System.out.println("你好Spring框架");

    }

}
