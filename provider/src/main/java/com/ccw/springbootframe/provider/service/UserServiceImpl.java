package com.ccw.springbootframe.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccw.springbootframe.model.TblTestUser;
import com.ccw.springbootframe.provider.mapper.TblTestUserMapper;
import com.ccw.springbootframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceName = "com.ccw.springbootframe.service.UserService", version = "1.0.0", timeout = 15000)
public class UserServiceImpl implements UserService {

    @Autowired
    private TblTestUserMapper tblTestUserMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public TblTestUser queryUserById(Integer id) {
        return tblTestUserMapper.selectByPrimaryKey(id);
    }

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
