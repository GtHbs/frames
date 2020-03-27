package rabbitmq.transaction;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.Utils.ConnectionUtils;


/**
 * @Author: 李昭
 * @Date: 2020/3/18 15:57
 */
public class Send {
    private static final String EXCHANGE_NAME = "transaction_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String msg = "transaction exchange";
        try {
            channel.txSelect();
            channel.basicPublish(EXCHANGE_NAME, "info", null, msg.getBytes());
            int i = 1 / 0;
            channel.txCommit();
        } catch (Exception e) {
            System.out.println("exception---------");
            channel.txRollback();
        } finally {
            channel.close();
            connection.close();
        }
    }
}
