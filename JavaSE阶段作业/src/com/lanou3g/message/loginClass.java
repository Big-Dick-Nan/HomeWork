package com.lanou3g.message;



import com.lanou3g.abnormal.EatException;
import com.lanou3g.abnormal.LoginException;
import com.lanou3g.abnormal.PassWordException;
import com.lanou3g.tools.Toolkit;
import com.lanou3g.tools.XMLTool;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


import java.io.File;
import java.util.List;

public class loginClass {
    static UserMessage us;
    public static UserMessage login(String username,String password) throws DocumentException, EatException {

        List<UserMessage> user =
                XMLTool.listElements();


        for (UserMessage o : user) {
            us =  o;
            System.out.println(user);
            if(us.getUserName() == null){
                throw new LoginException();
            }
            if(!password.equals(us.getUserPassWord())){
                System.out.println("登陆失败");
                throw new PassWordException();
            }


        }

        System.out.println("登陆成功");
        return us;
    }

}
