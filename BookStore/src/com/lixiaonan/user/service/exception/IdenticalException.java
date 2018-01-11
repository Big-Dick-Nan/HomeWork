package com.lixiaonan.user.service.exception;

public class IdenticalException extends RegisterException {
    public String getMessage() {
        return "账号已存在";
    }
}
