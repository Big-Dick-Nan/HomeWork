package com.lanou3g.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Toolkit {
    //判断邮箱
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("[a-zA-Z0-9_\\-\\.]+@(sina|qq|163)+(\\.(com|cn|org|edu|hk))"); //简单匹配
        Pattern p =  Pattern.compile("\\w+\\x40\\w+\\x2e\\w+");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }
//判断手机号

    public static boolean isMobile(String phone){
        Pattern p = Pattern.compile("^((13[0-9])|(14[57])|(15[^4,\\D])|(17[0,6-8])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }
//判断密码

    public static boolean isPassWord(String passWord){
        Pattern p = Pattern.compile("^(?![A-Za-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,14}$");
        Matcher m = p.matcher(passWord);
        return m.matches();
    }


}
