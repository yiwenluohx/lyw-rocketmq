package com.study.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luohx
 * @Description: 批量发送消息
 * @Date: 2021/7/7 0007 15:58
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //a、创建消息生产者producer，并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //b、指定Nameserver地址
        producer.setNamesrvAddr("49.232.217.148:9876;49.232.189.29:9876");
        //c、启动producer
        producer.start();
        List<Message> msgs = new ArrayList<>();

        //4.创建消息对象，指定主题Topic、Tag和消息体
        /**
         * 参数一：消息主题Topic
         * 参数二：消息Tag
         * 参数三：消息内容
         */
        Message msg1 = new Message("BatchTopic", "Tag1", ("Hello World" + 1).getBytes());
        Message msg2 = new Message("BatchTopic", "Tag1", ("Hello World" + 2).getBytes());
        Message msg3 = new Message("BatchTopic", "Tag1", ("Hello World" + 3).getBytes());

        msgs.add(msg1);
        msgs.add(msg2);
        msgs.add(msg3);

        //e、发送消息
        SendResult result = producer.send(msgs);
        System.out.println("发送结果：" + result);
        //线程睡1s
        TimeUnit.SECONDS.sleep(1L);

//        f、关闭生产者producer
        producer.shutdown();

        //把大的消息分裂成若干个小的消息
        /*ListSplitter splitter = new ListSplitter(messages);
        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                producer.send(listItem);
            } catch (Exception e) {
                e.printStackTrace();
                //处理error
            }
        }*/
    }
}
