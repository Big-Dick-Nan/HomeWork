package com.lixiaonan.user.service.exception;

public class InvalidUsernameException extends LonginException {
    @Override
    public String getMessage(){
        return "无效的";
    }
}
