package com.hb.controller;

import com.hb.pojo.Cart;
import com.hb.service.CartService;
import com.hb.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/index")
    public String index(){
        return "gouwu";
    }

    /*@RequestMapping("/query")
    @ResponseBody
    public SysResult doQuery(Cart cart){
        try {
            cart.setUserId(3);
            List<Cart> list = cartService.findCart(cart);
            if(list!=null && list.size()!=0)
                return SysResult.ok(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }*/

    @RequestMapping("/add")
    @ResponseBody
    public SysResult doAddCart(Cart cart){
        try {
            cartService.insertCart(cart);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public SysResult doDelete(Cart cart){
        try {
            cartService.deleteCart(cart);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }

    @RequestMapping("/update")
    @ResponseBody
    public SysResult doUpdateCart(Cart cart){
        try {
            cartService.updateCart(cart);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }


    @RequestMapping("/queryByUID")
    @ResponseBody
    public SysResult doQueryByUID(String yhm){
    	System.out.println("queryByUID: " + yhm);
        try {
            Cart cart = new Cart().setYhm(yhm);
            List<Cart> list = cartService.findCartByUID(cart);
            if(list!=null && list.size()!=0)
                return SysResult.ok(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }


    @RequestMapping("/deleteAll")
    @ResponseBody
    public SysResult doDeleteAll(String yhm){
        try {
            Cart cart = new Cart().setYhm(yhm);
            cartService.deleteCartAll(cart);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }
}