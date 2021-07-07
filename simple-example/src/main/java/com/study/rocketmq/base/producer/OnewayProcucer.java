package com.study.rocketmq.base.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * @Author: luohx
 * @Description: 发送单向消息
 * @Date: 2021/7/7 0007 9:45
 */
public class OnewayProcucer {
    public static void main(String[] args) throws Exception{
        //        a、创建消息生产者producer，并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
//        b、指定Nameserver地址
        producer.setNamesrvAddr("49.232.217.148:9876;49.232.189.29:9876");
//        c、启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            //d、创建消息对象，指定主题Topic、Tag和消息体
            /**
             * 参数一：消息主题Topic
             * 参数二：消息Tag
             * 参数三：消息内容
             */
            Message msg = new Message("base", "Tag3", ("Hello World，单向消息" + i).getBytes());
            //e、发送单向消息
            producer.sendOneway(msg);
            //线程睡1s
            TimeUnit.SECONDS.sleep(1L);
        }
//        f、关闭生产者producer
        producer.shutdown();
    }
}
