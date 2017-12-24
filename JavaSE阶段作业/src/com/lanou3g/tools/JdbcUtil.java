package com.lanou3g.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/jdbc.properties"));
            String driverName = prop.getProperty("driverName");

            url = prop.getProperty("url");
            user = prop.getProperty("user");
            passWord = prop.getProperty("password");
            database = prop.getProperty("database");
            //1.注册驱动  Manager(管理)
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(
                    e.getMessage() + "\n\t\t" + "请将配置文件jdbc.properties放在src文件下"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String user;
    private static String passWord;
    private static String database;
    private static String url;

    public static Connection getConnection()  {

        try {
            //第二步登录
            Connection conn = DriverManager.getConnection
                    (url + database,user,passWord);
            return conn;
        }  catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


    public  static void  execute(ExcuteInter e ){
        try {

            Connection conn = DriverManager.getConnection(url+database,user,passWord);
            e.execute(conn).close();
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }




    public static void showRs(ResultSet rs){


        try {
            while (rs.next()){
                System.out.print(rs.getString(1) +"\t");
                System.out.print(rs.getString(2) +"\t");
                System.out.print(rs.getString(3) +"\t");
                System.out.print(rs.getString(4) +"\t");
                System.out.println(" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}
