package rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;


/**
 * confirm普通模式
 *
 * @Author: 李昭
 * @Date: 2020/3/18 19:01
 */
public class SimpleSender {
    private static final String QUEUE_NAME = "confirm_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //将其设置为confirm模式
        channel.confirmSelect();
        String msg = "confirm message";
        for (int i = 0; i < 30; ++i) {
            channel.basicPublish("",QUEUE_NAME,null,(msg + i).getBytes());
        }
        if (!channel.waitForConfirms()) {
            System.out.println("消息发送失败");
        } else {
            System.out.println("消息发送成功");
        }
        channel.close();
        connection.close();
    }
}
