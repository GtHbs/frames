package rabbitmq.direct;

import com.rabbitmq.client.*;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;

/**
 * @Author: 李昭
 * @Date: 2020/3/17 18:19
 */
public class Receive {
    private static final String EXCHANGE_NAME = "test_exchange_routing_direct";
    private static final String QUEUE_NAME = "test_queue_routing_direct";

    public static void main(String[] args) throws Exception {
        String[] arg = {"error", "info", "error", "warning"};
        for (int i = 0; i < arg.length; ++i) {
            final String a = arg[i];
            final String x = String.valueOf(i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue(QUEUE_NAME + ":" + a + x, a);
                }
            }).start();
        }
    }

    /**
     * 直接路由,只能发给固定的队列
     *
     * @param queueName
     * @param args
     */
    public static void queue(String queueName, String args) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(queueName, false, false, false, null);
            //一次确认只给一个队列发送消息
            channel.basicQos(1);
            channel.queueBind(queueName, EXCHANGE_NAME, args);
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String msg = new String(body, "UTF-8");
                    System.out.println(queueName + ":" + msg);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            };
            boolean autoAck = false;
            channel.basicConsume(queueName, autoAck, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
