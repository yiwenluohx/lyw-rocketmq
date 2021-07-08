package com.study.rocketmq.test;

import com.study.rocketmq.MQProducerApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/7/8 0008 17:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MQProducerApplication.class})
@Slf4j
public class ProducerTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testSendMessage() {
        rocketMQTemplate.convertAndSend("springboot-rocketmq", "Hello Springboot Rocketmq");
        log.info("消息发送成功");
    }
}
