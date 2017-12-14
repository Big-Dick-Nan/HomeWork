package com.lanou3g.abnormal;

public class RegisterException extends EatException{
    public String getMessage() {
        return "注册失败!!!请检查你的账号或密码是否按照注册规则填写";
    }
}

