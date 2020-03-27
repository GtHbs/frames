package rabbitmq.work;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;

/**
 * @Author: 李昭
 * @Date: 2020/3/17 16:42
 */
public class Receive {
    private static final String QUEUE_NAME = "work_queue";
    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
        for (int i = 0; i < 2; ++i) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    test(Thread.currentThread().getName());
                }
            }).start();
        }
    }

    public static void test(String name) throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        /**
         * true:一旦rabbitmq将消息发送给消费者,就会从队列中删除,如果杀死正在执行的消费者,就会造成数据丢失
         * false:手动模式,如果有一个消费者挂了,则将该消息传给其他消费者处理
         */
        channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, "UTF-8");
                System.out.println(name + ":" + s);
                //公平分发
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
