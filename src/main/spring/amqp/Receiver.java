package spring.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author: 李昭
 * @Date: 2020/3/18 20:45
 */
@Component
public class Receiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
