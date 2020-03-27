package rabbitmq.fanout;

import com.rabbitmq.client.*;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;

/**
 * 广播接收消息
 *
 * @Author: 李昭
 * @Date: 2020/3/17 17:48
 */
public class Receive {

    private static Connection connection = ConnectionUtils.getConnection();
    private static final String QUEUE_NAME = "exchange_queue_fanout";
    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) {

        /**
         * 通过多线程创建多个队列接收消息
         */
        for (int i = 0; i < 2; ++i) {
            final String x = String.valueOf(i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue(QUEUE_NAME + x, Thread.currentThread().getName());
                }
            }).start();
        }
    }

    public static void queue(String queueName, String threadName) {
        Channel channel;
        try {
            channel = connection.createChannel();
            //声明队列
            channel.queueDeclare(queueName, false, false, false, null);
            //绑定队列到转发器
            channel.queueBind(queueName, EXCHANGE_NAME, "");
            channel.basicConsume(queueName,false,new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String msg = new String(body, "UTF-8");
                    System.out.println(threadName + ":" + msg);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
