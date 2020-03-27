package rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;

import java.util.UUID;

/**
 * 单对单发送消息
 *              |----------|
 *  sender ---> | exchange | ----> {queue}
 *              |----------|
 *
 * @Author: 李昭
 * @Date: 2020/3/17 18:15
 */
public class Send {
    private static final String EXCHANGE_NAME = "test_exchange_routing_direct";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String msg = UUID.randomUUID().toString();
        String routeKey = "warning";
        channel.basicPublish(EXCHANGE_NAME,routeKey,null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
