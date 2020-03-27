package rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;

import java.util.UUID;


/**
 * 通过交换机像队列发送消息(广播模式)
 *
 *             |----------|-----> {queue02}
 *  sender --->| exchange |-----> {queue01}
 *             |----------|-----> {queue03}
 *
 *
 * @Author: 李昭
 * @Date: 2020/3/17 17:42
 */
public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机,为分发模式(每个队列都能接收到)
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //发送消息
        String msg = UUID.randomUUID().toString();
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
        System.out.println("send:"+msg);
        channel.close();
        connection.close();
    }
}
