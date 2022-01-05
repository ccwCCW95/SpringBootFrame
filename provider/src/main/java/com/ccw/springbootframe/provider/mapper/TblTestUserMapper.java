/*
 * @Author: Changwei Cao
 * @Date: 2022-01-05 13:21:47
 * @LastEditors: Changwei Cao
 * @LastEditTime: 2022-01-05 15:18:02
 * @Description: 用户表数据映射接口
 */
package com.ccw.springbootframe.provider.mapper;

import com.ccw.springbootframe.model.TblTestUser;

public interface TblTestUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblTestUser record);

    int insertSelective(TblTestUser record);

    TblTestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblTestUser record);

    int updateByPrimaryKey(TblTestUser record);

    Integer selectAllCount();
}