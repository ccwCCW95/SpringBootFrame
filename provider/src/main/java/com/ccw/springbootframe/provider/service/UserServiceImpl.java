/*
 * @Author: Changwei Cao
 * @Date: 2022-01-05 13:21:47
 * @LastEditors: Changwei Cao
 * @LastEditTime: 2022-01-05 15:21:02
 * @Description: 服务接口实现类(接口保存在接口工程)
 */
package com.ccw.springbootframe.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccw.springbootframe.model.TblTestUser;
import com.ccw.springbootframe.provider.mapper.TblTestUserMapper;
import com.ccw.springbootframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//将此service交于spring容器管理
@Component
//使用Dubbo的service注解，暴露服务
@Service(interfaceName = "com.ccw.springbootframe.service.UserService", version = "1.0.0", timeout = 15000)
public class UserServiceImpl implements UserService {

    @Autowired
    private TblTestUserMapper tblTestUserMapper;

    //注入redis模板
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public TblTestUser queryUserById(Integer id) {
        return tblTestUserMapper.selectByPrimaryKey(id);
    }

    //使用redis
    @Override
    public Integer queryAllUserCount() {

        Integer allCount = (Integer) redisTemplate.opsForValue().get("allCount");

        if(null == allCount){
            allCount = tblTestUserMapper.selectAllCount();

            redisTemplate.opsForValue().set("allCount",allCount,30,TimeUnit.SECONDS);
        }

        return allCount;
    }
}
