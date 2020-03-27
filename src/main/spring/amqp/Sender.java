package spring.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 李昭
 * @Date: 2020/3/18 20:45
 */
@Service
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendData(String queue,Object o) {
        amqpTemplate.convertAndSend(queue,o);
    }
}
