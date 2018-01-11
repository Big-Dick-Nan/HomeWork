package com.lixiaonan.cart.dao;

import com.lixiaonan.cart.daomain.Cart;
import com.lixiaonan.cart.daomain.Cartltem;

import java.util.Map;

public class CartDao {

    public void delete(Cart cart,String bid){

        Map<String, Cartltem> map = cart.getCart();
        if (map!=null) {
            map.remove(bid);
        }
    }

    public void clear(Cart cart) {
        Map<String, Cartltem> cart1 = cart.getCart();
        for (String s : cart1.keySet()) {
            cart1.remove(s);
        }
    }

}
