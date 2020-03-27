package rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单直连,一个发送者对应一个接收者,中间只有一个队列接收消息
 *              |------------|
 *  sender ---> |   queue    | ---> receiver
 *              |------------|
 *
 * @Author: 李昭
 * @Date: 2020/3/17 15:18
 */
public class Send {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String msg = "Hello RabbitMQ";
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        System.out.println("---send Msg:" + msg);
        channel.close();
        connection.close();
    }
}
