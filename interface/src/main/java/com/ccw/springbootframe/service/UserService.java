package com.ccw.springbootframe.service;

import com.ccw.springbootframe.model.TblTestUser;

public interface UserService {
    TblTestUser queryUserById(Integer id);

    Integer queryAllUserCount();
}
