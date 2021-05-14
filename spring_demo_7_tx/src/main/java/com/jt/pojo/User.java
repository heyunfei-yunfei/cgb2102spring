package com.jt.pojo;

public class User {
    private Integer id;
    private String name;
    /*业务中实体对象不会交给Spring容器管理 所以需要添加方法*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
