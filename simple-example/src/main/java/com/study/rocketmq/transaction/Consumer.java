package com.study.rocketmq.transaction;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @Author: luohx
 * @Description: 消息接收者
 * @Date: 2021/7/7 0007 10:11
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //a、创建消费者Consumer,指定消费者组名
        DefaultMQPushConsumer mqConsumer = new DefaultMQPushConsumer("group5");
        //b、指定Nameserver地址
        mqConsumer.setNamesrvAddr("49.232.217.148:9876;49.232.189.29:9876");
        //c、订阅主题Topic和Tag
        mqConsumer.subscribe("TransactionTopic", "*");

        //d、设置回调函数，处理消费
        //接收消息内容
        mqConsumer.registerMessageListener((MessageListenerConcurrently) (msgs, consumeConcurrentlyContext) -> {
            for (MessageExt msg : msgs) {
                System.out.println("消费消息：" + new String(msg.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        //e、启动消费者consumer
        mqConsumer.start();

        System.out.println("事务消费者启动");

    }
}
