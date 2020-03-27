package spring.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: 李昭
 * @Date: 2020/3/19 11:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/redis/application.xml")
public class RedisTest {

    @Autowired(required = false)
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void testStringRedis() {
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("name","alone");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
