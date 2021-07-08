package com.study.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: luohx
 * @Description: springboot整合rocketmq的生产者
 * @Date: 2021/7/8 0008 17:33
 */
@SpringBootApplication
public class MQProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MQProducerApplication.class, args);
    }
}
