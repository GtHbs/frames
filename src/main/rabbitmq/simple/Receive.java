package rabbitmq.simple;

import com.rabbitmq.client.*;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;

/**
 * 接收消息
 *
 * @Author: 李昭
 * @Date: 2020/3/17 16:13
 */
public class Receive {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        /**
         * 创建一个管道
         */
        Channel channel = connection.createChannel();
        /**
         * 声明一个队列
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /**
         * 消费者
         */
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, "UTF-8");
                System.out.println(s);
            }
        };
        //监听队列的消息(阻塞监听)
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    /**
     * 过期做法
     *
     * @throws Exception
     */
    public static void outOfDate() throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        /**
         * false:服务端手动确认消息已送达
         * true:自动确认
         */
        channel.basicConsume(QUEUE_NAME, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String s = new String(delivery.getBody());
            System.out.println(s);
        }
    }
}
