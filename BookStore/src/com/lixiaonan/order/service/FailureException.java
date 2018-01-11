package com.lixiaonan.order.service;
public class FailureException extends Exception{
    @Override
    public String getMessage() {
        return "订单确认失败";
    }
}





