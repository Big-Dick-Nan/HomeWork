package com.lanou3g;

import com.lanou3g.abnormal.EatException;
import com.lanou3g.abnormal.RegisterException;
import com.lanou3g.message.RegisterClass;
import com.lanou3g.message.UserMessage;
import com.lanou3g.message.loginClass;
import com.lanou3g.tools.JSONManage;
import org.dom4j.DocumentException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int REGISTER_CODE = 1;
    private static final int LOGIN_CODE = 2;
    private static final int WEATHER_CODE = 1;
    private static final int PHONE_CODE = 2;
    private static final int GEAM_CODE = 3;
    private static final int SHOUSU_CODE = 4;
    private static String password;
    private static String username;
    private static String name;
    private static UserMessage usme;
    public static void main(String[] args) throws IOException {



        Scanner input = new Scanner(System.in);

       d: while (true) {
            System.out.println("1，注册	2，登录");
            int choice = input.nextInt();
            input.nextLine();
            a:switch (choice){
                case REGISTER_CODE:
                  b:  while (true) {


                      register(input);
                        try {
                            RegisterClass.judgeReg(usme);
                        } catch (IOException e) {

                            continue;
                        } catch (RegisterException e) {
                            System.out.println(e.getMessage());
                            continue ;
                        }
                        System.out.println("注册成功");
                        System.out.println(usme);

                        break b;
                    }

                case LOGIN_CODE:

                    login(input);
                    try {

                        usme = loginClass.login(username, password);

                    } catch (DocumentException e) {
                        continue ;
                    } catch (com.lanou3g.abnormal.LoginException e) {
                        System.out.println(e.getMessage());
                        continue ;
                    } catch (EatException e) {
                        System.out.println(e.getCause());
                        continue ;
                    }


                    break d;
            }



        }


        System.out.println("欢迎"+usme.getName()+"来到本系统");
        while (true) {
            System.out.println("1查询天气\n" +
                    "2查询手机号归属地\n" +
                    "3手速游戏\n" +
                    "4查询手速游戏前十用户");
            int choice = input.nextInt();
            input.nextLine();

            a:
            switch (choice) {
                case REGISTER_CODE:
                    System.out.println("请输入查询地址:");
                    String city = input.nextLine();
                    JSONManage.Tq(city);
                    break;
                case PHONE_CODE:
                    System.out.println("请输入查询手机号:");
                    String ph = input.nextLine();
                    JSONManage.phone(ph);
                    break;

            }

        }














    }


    public static void  register(Scanner input){

        System.out.println("请输入用户名：");
        System.out.println("用户名必须是手机或者邮箱");
         username = input.nextLine();

        System.out.println("请输入密码：");
        System.out.println("密码要大于6位小于14位，一定要有大小写字母和数字");
         password = input.nextLine();


        System.out.println("请输昵称(必须是英文昵称)");

         name = input.nextLine();
         usme = new UserMessage(username, password,name);



    }



    public static void login (Scanner input){

        System.out.println("请输入用户名：");
        username = input.nextLine();
        System.out.println("请输入密码：");
        password = input.nextLine();
    }




}
