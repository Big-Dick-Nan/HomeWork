package com.lixiaonan.cart.daomain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String,Cartltem> carts = new HashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cart=" + carts +
                '}';
    }

    public Map<String, Cartltem> getCart() {
        return carts;
    }

    public void setCart(Map<String, Cartltem> cart) {
        this.carts = cart;
    }

    public Cart() {

    }

    public Cart(Map<String, Cartltem> cart) {

        this.carts = cart;
    }
}
