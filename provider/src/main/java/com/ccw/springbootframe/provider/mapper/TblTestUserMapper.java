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