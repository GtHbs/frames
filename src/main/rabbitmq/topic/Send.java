package rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 按照匹配模式发送消息
 *
 *               |----------| ----> {xxx.#}
 * sender  ----> | exchange | ----> {xxx.aaa}
 *               |----------| ----> {xxx.*}
 *
 * @Author: 李昭
 * @Date: 2020/3/17 18:46
 */
public class Send {
    private static final String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String routingKey = "goods.delete";
            String msg = "topic exchange";
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
            System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
