package rabbitmq.transaction;

import com.rabbitmq.client.*;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;

/**
 * @Author: 李昭
 * @Date: 2020/3/18 16:01
 */
public class Receive {
    private static final String EXCHANGE_NAME = "transaction_exchange";
    private static final String QUEUE_NAME = "transaction_queue";
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println(QUEUE_NAME + ":" + msg);
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
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }
}
