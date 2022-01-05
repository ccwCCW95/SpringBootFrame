/*
 * @Author: Changwei Cao
 * @Date: 2022-01-05 13:21:47
 * @LastEditors: Changwei Cao
 * @LastEditTime: 2022-01-05 15:16:54
 * @Description: 抽象接口
 */
package com.ccw.springbootframe.service;

import com.ccw.springbootframe.model.TblTestUser;

public interface UserService {
    TblTestUser queryUserById(Integer id);

    Integer queryAllUserCount();
}
