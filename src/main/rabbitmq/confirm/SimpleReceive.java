package rabbitmq.confirm;

import com.rabbitmq.client.*;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;

/**
 * @Author: 李昭
 * @Date: 2020/3/18 19:06
 */
public class SimpleReceive {
    private static final String QUEUE_NAME = "confirm_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicConsume(QUEUE_NAME,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body,"UTF-8"));
            }
        });
    }

}
