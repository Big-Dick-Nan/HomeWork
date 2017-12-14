package com.lanou3g.message;

import com.lanou3g.abnormal.RegisterException;
import com.lanou3g.tools.Toolkit;
import com.lanou3g.tools.XMLTool;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterClass {

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
