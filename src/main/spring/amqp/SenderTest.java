package spring.amqp;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 李昭
 * @Date: 2020/3/18 21:00
 */
class SenderTest {

    @Autowired
    static Sender sender;
    private static final String queue = "test_spring_queue";

    public static void main(String[] args) {
        User user = new User();
        user.setAge(10);
        user.setName("alone");
        sender.sendData(queue,user);
    }
}