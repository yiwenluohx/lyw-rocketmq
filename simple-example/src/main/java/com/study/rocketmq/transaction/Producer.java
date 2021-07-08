package com.study.rocketmq.transaction;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.TimeUnit;

/**
 * @Author: luohx
 * @Description: 发送事务消息
 * @Date: 2021/7/6 0006 16:18
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //创建消息生产者producer，并指定生产者组名
        DefaultMQProducer producer = new TransactionMQProducer("group5");
        //指定Nameserver地址
        producer.setNamesrvAddr("49.232.217.148:9876;49.232.189.29:9876");

        //添加事务监听器
        ((TransactionMQProducer) producer).setTransactionListener(new TransactionListener() {
            /**
             * 在该方法中执行本地事务
             * @param msg
             * @param arg
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if (StringUtils.equals("TAGA", msg.getTags())) {
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if (StringUtils.equals("TAGB", msg.getTags())) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else if (StringUtils.equals("TAGC", msg.getTags())) {
                    return LocalTransactionState.UNKNOW;
                }
                return LocalTransactionState.UNKNOW;
            }

            /**
             * 该方法时，MQ进行消息事务状态回查
             * @param msg
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("消息的Tag:" + msg.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        //启动producer
        producer.start();
        String[] tags = {"TAGA", "TAGB", "TAGC"};
        for (int i = 0; i < 3; i++) {
            //创建消息对象，指定主题Topic、Tag和消息体
            /**
             * 参数一：消息主题Topic
             * 参数二：消息Tag
             * 参数三：消息内容
             */
            Message msg = new Message("TransactionTopic", tags[i], ("Hello World" + i).getBytes());
            //发送消息
            SendResult result = producer.sendMessageInTransaction(msg, null);
            System.out.println("事务消息发送结果：" + result);
            //线程睡1s
            TimeUnit.SECONDS.sleep(1L);
        }
        //关闭生产者producer,mq需要回查消息生产者，所以不能停掉
        //producer.shutdown();
    }
}
