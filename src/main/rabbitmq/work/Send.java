package rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;

import java.util.UUID;

/**
 * 一对多发送消息
 *
 *             {queue02}
 * sender ---> {queue01}
 *             {queue03}
 *
 * @Author: 李昭
 * @Date: 2020/3/17 16:37
 */
public class Send {
    private static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //每次确认只给一个消费者发送消息
        channel.basicQos(1);
        for (int i = 0; i < 50; ++i) {
            String msg = UUID.randomUUID().toString().substring(0, 10);
            System.out.println("send:" + msg);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(i * 20);
        }
        channel.close();
        connection.close();
    }
}
