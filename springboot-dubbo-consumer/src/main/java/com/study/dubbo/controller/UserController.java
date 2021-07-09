package com.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.dubbo.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/7/9 0009 16:25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private IUserService userService;

    @RequestMapping("/sayHello")
    public String sayHello(String name) {
        return userService.sayHello(name);
    }
}
