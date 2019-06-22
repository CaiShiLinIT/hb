package com.hb.atest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisHashTest {
    @Autowired
    private JedisCluster jedisCluster;


    @Test
    public void test01(){
        jedisCluster.hset("ab", "ab", "ab");
        jedisCluster.hset("ab", "cd", "cdcd");
        jedisCluster.hset("ab", "ab", "bbb");
        String hget = jedisCluster.hget("ab", "ab");

        System.out.println(hget);
    }
}
