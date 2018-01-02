package homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Server extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("uname");
        String age = req.getParameter("age");
        String loc = req.getParameter("loc");
        System.out.println(username+"  "+age);
        JDBCUtil.show(username, age, loc);
        resp.getWriter().write("chenggong");

    }


}
