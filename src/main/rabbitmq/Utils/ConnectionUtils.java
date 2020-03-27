package rabbitmq.Utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: 李昭
 * @Date: 2020/3/17 15:13
 */
public class ConnectionUtils {

    /**
     * 获取消息队列连接
     *
     * @return
     */
    public static Connection getConnection(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.107");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
