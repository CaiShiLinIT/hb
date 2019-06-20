package com.hb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

@Component
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {

    @Value("${redis.nodes}")
    private String nodes;

    @Bean
    public JedisCluster jedisCluster(){
        HashSet<HostAndPort> set = new HashSet<>();
        String[] node = nodes.split(",");
        for (String ipPort : node) {
            String[] temp = ipPort.split(":");
            set.add(new HostAndPort(temp[0],Integer.valueOf(temp[1])));
        }
        return new JedisCluster(set);
    }
}
