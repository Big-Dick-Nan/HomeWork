package com.lanou3g;

import com.lanou3g.abnormal.EatException;
import com.lanou3g.abnormal.RegisterException;
import com.lanou3g.message.GameClass;
import com.lanou3g.message.RegisterClass;
import com.lanou3g.message.UserMessage;
import com.lanou3g.message.loginClass;
import com.lanou3g.tools.JSONManage;
import org.dom4j.DocumentException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private static final int TIMES_DIFFICULT = 30;
    private static final int TIMES_MIDDLE = 20;
    private static final int TIMES_EASY = 10;
    //定义一个char类型结合
    private static List difficult;
    private static List middle;
    private static List easy;


    public static void main(String[] args) throws IOException {


      //  initGame();
        Scanner input = new Scanner(System.in);

       // GameClass.startGame(easy, TIMES_EASY);


       d: while (true) {
            System.out.println("1，注册	2，登录");
            int choice = input.nextInt();
            input.nextLine();
            a:switch (choice){
                case REGISTER_CODE:
                  b:  while (true) {


                      register(input);
                      RegisterClass.jude(usme);
//                        try {
//                            RegisterClass.judgeReg(usme);
//
//                        } catch (IOException e) {
//
//                            continue;
//                        } catch (RegisterException e) {
//                            System.out.println(e.getMessage());
//                            continue ;
//                        }
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
                case WEATHER_CODE:
                    System.out.println("请输入查询地址:");
                    String city = input.nextLine();
                    JSONManage.Tq(city);
                    break;
                case PHONE_CODE:
                    System.out.println("请输入查询手机号:");
                    String ph = input.nextLine();
                    JSONManage.phone(ph);
                    break;
                case GEAM_CODE:
                    System.out.println("请选择游戏难度:1简单,2中级,3,高级");
                    int game = input.nextInt();

                    switch (game) {
                        case 3:
                            GameClass.startGame(difficult, TIMES_DIFFICULT);
                            break;
                        case 2:
                            GameClass.startGame(middle, TIMES_MIDDLE);
                            break;
                        case 1:
                            GameClass.startGame(easy, TIMES_EASY);
                            break;
                    }
                    break;

                case SHOUSU_CODE:
                    JSONManage.inquiry();

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

    private static void initGame() {

        difficult = new ArrayList();
        middle = new ArrayList<>();
        easy = new ArrayList<>();
        //32是空格，126是~
        for (char i = 32; i <= 126; i++) {
            difficult.add(i);
        }

        //大写字母
        for (char i = 65; i <= 90; i++) {
            middle.add(i);
        }
        //小写字母
        for (char i = 97; i <= 122; i++) {
            middle.add(i);
        }
        //数字
        for (char i = 48; i <= 57; i++) {
            middle.add(i);
        }


        //小写字母
        for (char i = 97; i <= 122; i++) {
            easy.add(i);
        }
        //数字
        for (char i = 48; i <= 57; i++) {
            easy.add(i);
        }
    }
}
