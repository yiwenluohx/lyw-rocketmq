package com.study.rocketmq.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @Author: luohx
 * @Description: 生产者
 * @Date: 2021/7/7 0007 11:58
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //a、创建消息生产者producer，并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //b、指定Nameserver地址
        producer.setNamesrvAddr("49.232.217.148:9876;49.232.189.29:9876");
        //c、启动producer
        producer.start();
        //构建消息集合
        List<OrderStep> orderSteps = OrderStep.buildOrders();
        //发送消息
        for (int i = 0; i < orderSteps.size(); i++) {
            String body = orderSteps.get(i) + "";
            Message message = new Message("OrderTopic", "Order", "i" + i, body.getBytes());
            /**
             * 参数一：消息对象
             * 参数二：消息队列选择器
             * 参数三：选择队列的业务标识（订单ID）
             */
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs  队列集合
                 * @param msg  消息对象
                 * @param arg  业务标识的参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    long orderId = (long) arg;
                    long index = orderId % mqs.size();
                    return mqs.get((int) index);
                }
            }, orderSteps.get(i).getOrderId());
            System.out.println("发送结果：" + sendResult);
        }
        producer.shutdown();
    }
}
