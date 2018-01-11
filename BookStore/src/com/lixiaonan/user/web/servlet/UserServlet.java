package com.lixiaonan.user.web.servlet;

import com.lixiaonan.cart.daomain.Cart;
import com.lixiaonan.user.dao.UserDao;
import com.lixiaonan.user.domain.User;
import com.lixiaonan.user.service.UserService;
import com.lixiaonan.user.service.exception.LonginException;
import com.lixiaonan.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    private UserService loginServlet = new UserService();
    private UserDao userDao = new UserDao();

    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User formU = new User();
        formU.setUsername(username);
        formU.setPassword(password);
        try {
            User login = loginServlet.login(formU);
            HttpSession session = request.getSession();
            request.getSession().setAttribute("user", login);
            request.getSession().setAttribute("cart",new Cart());
            session.setAttribute("username", formU.getUsername());
            return "f:/jsps/main.jsp";
        } catch (LonginException e) {
            request.setAttribute("errorMag", e.getMessage());
            return "r:/jsps/user/login.jsp";

        }

    }

    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException {
        System.out.println("register 被调用了");

        User user = new User();

        try {
            BeanUtils.populate(user, request.getParameterMap());
            String formName = user.getUsername();
            System.out.println("++++++++" + formName);

            User fromDb = userDao.queryByUsername(formName);

            if (fromDb != null) {
                return "f:/jsps/user/regist.jsp";
            }

            userDao.insert(user);
            userDao.email(user);
            return "r:/jsps/user/login.jsp";

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String active(HttpServletRequest request, HttpServletResponse response){
        System.out.println("active 被调用了");
        String code = request.getParameter("code");
        User fromDb = userDao.queryByCode(code);
        if (fromDb == null){
            return "f:/jsps/user/regist.jsp";
        }

        if (fromDb.getCode().equals(code)){
            System.out.println("激活成功");
            try {
                userDao.amend();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "r:/jsps/user/login.jsp";
        }
        System.out.println(fromDb);
        return null;
    }

}



