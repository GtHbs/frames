package spring.redis;

import redis.clients.jedis.Jedis;

/**
 * @Author: 李昭
 * @Date: 2020/3/20 11:32
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.109");
        System.out.println(jedis.ping());
    }
}
