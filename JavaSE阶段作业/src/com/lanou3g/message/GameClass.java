package com.lanou3g.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameClass {


    private static Random random;


            //传入需要随机的list集合和需要随机的个数
            public static void startGame(List<Character> cs, int times) {

                random = new Random();
                StringBuilder game = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    int index = random.nextInt(cs.size() - 1);
                    game.append(cs.get(index));
                }

                for (int i = 3; i >= 0; i--) {
                    if (i == 0) {
                        System.out.println("游戏开始：");
                    } else {
                        System.out.println("倒计时" + i + "秒后开始");
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(game);

                long start = System.currentTimeMillis();
                Scanner input  = new Scanner(System.in);
                String receive = input.nextLine();
                String a = game.toString();
                if (a.equals(receive)) {
                    long end = System.currentTimeMillis();
                    long score = end - start;

                    Number number = new Long(score);
                    int time = number.intValue();

                    System.out.println("恭喜您，成绩为：" + time + "毫秒");

                } else {
                    System.out.println("游戏失败");
                }


            }

    }



