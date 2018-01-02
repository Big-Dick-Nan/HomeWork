package homework;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        List<User> users = null;
        try {
            users  = new QueryUtil().query(JDBCUtil.coll(), "select * from hw_user",
                    new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(users);
        for (User user : users) {

            if(user.getUname().equals(username)&&user.getAge().equals(age)){

                System.out.println(user.getUname()+"\t"+ user.getAge());
                System.out.println("哈哈哈");
                response.sendRedirect("http://localhost:8080/index.jsp");
            }else {
                RequestDispatcher dispatcher  =
                        request.getRequestDispatcher("/login.html");
                dispatcher.forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
