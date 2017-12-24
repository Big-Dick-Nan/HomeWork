package com.lanou3g.message;

import com.lanou3g.abnormal.RegisterException;
import com.lanou3g.tools.JdbcUtil;
import com.lanou3g.tools.Toolkit;
import com.lanou3g.tools.XMLTool;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterClass {
    @Test
    public  static void jude(UserMessage usme){

        JdbcUtil.execute(conn -> {

            try {

             //   PreparedStatement psate = conn.prepareStatement
                       // ("INSERT INTO  per VALUES( " + usme.getName() +"," + usme.getUserName() +"," + usme.getUserPassWord()+")");
                PreparedStatement psate = conn.prepareStatement("INSERT INTO  hw_user VALUES ( 'zhangsan','30','上海')");
                //将三十岁的张三插入到批处理中
                psate.addBatch();
                //添加预处理任务

                //开始执行预处理任务
                psate.executeBatch();
                return psate;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }) ;

    }






    public static void judgeReg(UserMessage usme) throws IOException, RegisterException {

        if (Toolkit.isMobile(usme.getUserName())||
                Toolkit.isEmail(usme.getUserName())&&
                        Toolkit.isPassWord(usme.getUserPassWord()))

        {
            register(usme);
        }else {
            throw new RegisterException();

        }
    }


    public static void register(UserMessage usme) throws IOException {

        XMLTool.LoadLine(usme);


    }
}
