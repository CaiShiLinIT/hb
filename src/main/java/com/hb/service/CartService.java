package com.hb.service;

import com.hb.pojo.CaiDan;
import com.hb.pojo.Cart;

import java.util.List;

public interface CartService {

    void updateCart(Cart cart);

    //List<Cart> findCart(Cart cart);

    void deleteCart(Cart cart);

    List<Cart> findCartByUID(Cart cart);

    void deleteCartAll(Cart cart);

    void insertCart(Cart cart);
}
