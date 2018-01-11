package com.lixiaonan.user.dao;

import com.lixiaonan.user.domain.User;

import com.lixiaonan.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;


public class UserDao {
    private QueryRunner qr = new QueryRunner();
    private String sendAddr = "392139720";
    private String receiveAddr = "745996101";

    private String pass = "zjgiiqqxcwdubjdc";

    public void amend() throws SQLException {
        String sql = "update user set state=1";
        Connection conn = JdbcUtil.getConnection();
        qr.update(conn,sql);
    }

    public User queryByCode(String coder){

        String sql = "select * from user where code = ?";
        Connection conn = JdbcUtil.getConnection();
        User user = new User();
        try {
            user = qr.query(conn, sql, new BeanHandler<User>(User.class), coder);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    public User queryByUsername(String username){
         String sql = "select * from user where username = ?";
        Connection conn = JdbcUtil.getConnection();
        User user = new User();
        try {
            user = qr.query(conn, sql, new BeanHandler<User>(User.class), username);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public void insert(User user) {
        String sql =
                "insert into user values(?,?,?,?,?,?)";
        Connection conn = JdbcUtil.getConnection();
        try {

            user.setUid(Uuid());
            user.setCode(Uuids(user.getUid()));
            qr.update(conn,sql,user.getUid(), user.getUsername(),user.getPassword(),user.getEmail(),user.getCode(),0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String Uuid(){
        UUID uuid  =  UUID.randomUUID();
       String str = UUID.randomUUID().toString();
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }

    private String Uuids(String string){
        UUID uuid  =  UUID.randomUUID();
        String str = UUID.randomUUID().toString();
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        String uuids = string +temp;
        return uuids;
    }



    public void email(User user) throws MessagingException {
        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.port","587");
//		prop.put("mail.transport.protocol", "smtp");

        //我们要登录一个账号,来给别人发邮件
        //现在先构建一个邮件账号，需要用邮件地址和密码
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddr+"@qq.com",pass);
            }
        };

        Session session = Session.getInstance(prop,auth);

        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(sendAddr+"@qq.com"));

        msg.setRecipients(Message.RecipientType.TO,user.getEmail());


        msg.setSubject("请激活你的商城账号");

        msg.setContent("<a href="+"http://localhost:8080/user?method=active&code="+user.getCode()+">点击激活购书商城</a>","text/html;charset=utf-8");

        Transport.send(msg);
    }


}
