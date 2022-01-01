package com.ccw.springbootframe.model;

import java.io.Serializable;

public class TblTestUser implements Serializable {
    private Integer id;

    private String name;

    private String age;

    public TblTestUser(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public TblTestUser() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }
}