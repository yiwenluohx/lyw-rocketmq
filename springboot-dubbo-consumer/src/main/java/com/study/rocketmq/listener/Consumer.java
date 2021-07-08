package com.study.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/7/8 0008 18:19
 */
@RocketMQMessageListener(topic = "springboot-rocketmq", consumerGroup = "${rocketmq.consumer.group}")
@Component
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("接收到消息：" + s);
    }
}
