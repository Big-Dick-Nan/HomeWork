package com.lixiaonan.user.service.exception;

public class PasswordNotMatchException extends LonginException {
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
