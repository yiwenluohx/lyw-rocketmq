package com.study.rocketmq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @Author: luohx
 * @Description: 消费者
 * @Date: 2021/7/7 0007 14:26
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //a、创建消费者Consumer,指定消费者组名
        DefaultMQPushConsumer mqConsumer = new DefaultMQPushConsumer("group1");
        //b、指定Nameserver地址
        mqConsumer.setNamesrvAddr("49.232.217.148:9876;49.232.189.29:9876");
        //c、订阅主题Topic和Tag
        mqConsumer.subscribe("OrderTopic", "*");
        //d、注册消息监听器
        mqConsumer.registerMessageListener((MessageListenerOrderly) (msgs, consumeOrderlyContext) -> {
            for (MessageExt msg : msgs) {
                System.out.println("线程名称：【"+ Thread.currentThread().getName() +"】：" + new String(msg.getBody()));
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        //e: 启动消费者
        mqConsumer.start();

        System.out.println("消费者启动啦");
    }
}
