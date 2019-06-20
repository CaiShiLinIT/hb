package com.hb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

/**
 * Redis配置类
 */
@Component
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {

    /**
     * 注入值
     */
    @Value("${redis.nodes}")
    private String nodes;

    /**
     * 交给spring容器
     * @return
     */
    @Bean
    public JedisCluster jedisCluster(){
        //1.准备Set集合
        HashSet<HostAndPort> set = new HashSet<>();
        //2.按逗号分割网址
        String[] node = nodes.split(",");
        for (String ipPort : node) {
            //3.分割成ip+端口号 创建HostAndPort实例，并加入到Set集合
            String[] temp = ipPort.split(":");
            set.add(new HostAndPort(temp[0],Integer.valueOf(temp[1])));
        }
        //5.创建JedisCluster实例并返回
        return new JedisCluster(set);
    }
}
