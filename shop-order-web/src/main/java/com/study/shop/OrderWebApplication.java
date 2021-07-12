package com.study.shop;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/7/12 0012 17:40
 */
@EnableDubboConfiguration
@SpringBootApplication
public class OrderWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderWebApplication.class, args);
    }
}
