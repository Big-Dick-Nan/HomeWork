package com.lanou3g.abnormal;

public class LoginException extends EatException {
    public String getMessage() {
        return "账号不存在";
    }
}
