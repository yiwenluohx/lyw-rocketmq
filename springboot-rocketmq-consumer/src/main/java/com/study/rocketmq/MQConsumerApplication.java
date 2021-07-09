package com.study.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: luohx
 * @Description: springboot整合rocketmq的消费端
 * @Date: 2021/7/8 0008 18:17
 */
@SpringBootApplication
@Slf4j
public class MQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MQConsumerApplication.class, args);
        log.info("消费者启动成功");
    }
}
