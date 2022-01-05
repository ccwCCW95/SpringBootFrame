/*
 * @Author: Changwei Cao
 * @Date: 2022-01-05 13:21:47
 * @LastEditors: Changwei Cao
 * @LastEditTime: 2022-01-05 15:15:59
 * @Description: 用户表实体类
 * 注意 要实现Serializable接口(Dubbo分布式要求)
 */
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