package com.hb.service.impl;

import com.hb.pojo.Cart;
import com.hb.service.CartService;
import com.hb.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void updateCart(Cart cart) {
    	System.out.println(cart);
        jedisCluster.hset("cart_"+cart.getYhm(), ""+cart.getCaiPinId(), JSONUtil.toJson(cart));
    }

    @Override
    public void deleteCart(Cart cart) {
        jedisCluster.hdel("cart_"+cart.getYhm(), ""+cart.getCaiPinId());
    }

    @Override
    public List<Cart> findCartByUID(Cart cart) {
    	System.out.println(cart);
        List<Cart> list = new ArrayList<>();
        Map<String, String> map = jedisCluster.hgetAll("cart_" + cart.getYhm());
        for (String value : map.values()) {
            Cart cacheCart = JSONUtil.toObject(value, Cart.class);
            list.add(cacheCart);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void deleteCartAll(Cart cart) {
    	System.out.println(cart);
        jedisCluster.del("cart_"+cart.getYhm());
    }

    @Override
    public void insertCart(Cart cart) {
    	System.out.println(cart);
        jedisCluster.hset("cart_"+cart.getYhm(), ""+cart.getCaiPinId(), JSONUtil.toJson(cart));
    }
}
