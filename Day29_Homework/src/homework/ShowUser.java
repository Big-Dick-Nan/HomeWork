package homework;

import net.sf.json.JSONArray;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        List<User> query = null;
        try {
          query  = new QueryUtil().query(JDBCUtil.coll(), "select * from hw_user",
                  new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = JSONArray.fromObject(query);
        System.out.println(jsonArray.toString());
        resp.getWriter().write(jsonArray.toString());
    }
}