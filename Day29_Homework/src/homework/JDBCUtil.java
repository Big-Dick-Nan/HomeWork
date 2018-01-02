package homework;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection coll(){
        Connection root=null;
        try {
             root = DriverManager.getConnection("jdbc:mysql://localhost:3306/day20", "root", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return root;

    }
    public static int show(String uname,String age,String loc ){
        int i=0;
        try {
             i= new QueryUtil().update(coll(), "insert into hw_user values(null,?,?,?)", uname,age,loc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }




}
