package com.hb.atest;

import com.hb.pojo.Cart;
import com.hb.util.SerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void test01(){
        String key = "admin456";
        ArrayList<Cart> carts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            carts.add(new Cart().setTitle("好运来"+new Date()));
        }
        Object data = carts;
        jedisCluster.set(key.getBytes(), SerializeUtil.serialize(data));
    }

    @Test
    public void test02(){
        String key = "admin456";
        byte[] in = jedisCluster.get(key.getBytes());
        List<Cart> objects = (List<Cart>) SerializeUtil.unserialize(in);
        System.out.println(objects);

    }

    @Test
    public void test03(){
        String key = "cart_3";
        byte[] in = jedisCluster.get(key.getBytes());
        List<Cart> objects = (List<Cart>) SerializeUtil.unserialize(in);
        System.out.println(objects);
    }

    @Test
    public void test04(){
        ArrayList<Cart> carts = new ArrayList<>();
        carts.add(new Cart().setCaiPinId(1).setShuLiang(1));
        carts.add(new Cart().setCaiPinId(2).setShuLiang(2));
        System.out.println(carts);
        for (Cart cart : carts) {
            if(cart.getCaiPinId() == new Cart().setCaiPinId(1).getCaiPinId()) {
                System.out.println("进");
                cart.setShuLiang(10);
            }
        }
        System.out.println(carts);
    }
}
