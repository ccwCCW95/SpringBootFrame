/*
 * @Author: Changwei Cao
 * @Date: 2022-01-05 13:21:47
 * @LastEditors: Changwei Cao
 * @LastEditTime: 2022-01-05 15:25:59
 * @Description: 控制器
 */
package com.ccw.springbootframe.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccw.springbootframe.model.TblTestUser;
import com.ccw.springbootframe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    //指定Dubbo服务
    @Reference(interfaceName = "com.ccw.springbootframe.service.UserService", version = "1.0.0", check = false)
    private UserService userService;

    @RequestMapping(value = "/user/detail/{id}")
    public String userDetail(Model model, @PathVariable("id") Integer id){
        TblTestUser user = userService.queryUserById(id);

        model.addAttribute("user", user);

        return "userDetail";
    }

    @GetMapping(value = "/user/all/count")
    public @ResponseBody Object allUserCount(){
        Integer allCount = userService.queryAllUserCount();

        return "总人数为：" + allCount;
    }
}
