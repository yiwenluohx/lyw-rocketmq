package com.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.dubbo.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/7/9 0009 14:38
 */

@Component
@Service(interfaceClass = IUserService.class)
public class UserServiceImpl implements IUserService {
    @Override
    public String sayHello(String name) {
        return "hello:" + name;
    }
}
