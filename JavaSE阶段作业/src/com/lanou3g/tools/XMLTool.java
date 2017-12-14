package com.lanou3g.tools;

import com.lanou3g.message.UserMessage;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLTool {
    private static Document document;
    private static Element element;

private static SAXReader reader;
    //写入
    public static void LoadLine(UserMessage usem) throws IOException {
        reader = new SAXReader();

        try {
            document = reader.read(new File("src/message.xml"));
            element = document.getRootElement();

        } catch (DocumentException e) {
            document = DocumentHelper.createDocument();
            element = document.addElement("User");
        }

        Element user = element.addElement("user");
        user.addAttribute("userName",usem.getUserName());

        Element name = user.addElement("name");
        name.addText(usem.getName());

        Element usNa = user.addElement("usNa");
        usNa.addText(usem.getUserName());

        Element passWord = user.addElement("passWord");
        passWord.addText(usem.getUserPassWord());



        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/message.xml"),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();

    }


    public static List<UserMessage> listElements() throws DocumentException {

        reader = new SAXReader();
         document = reader.read(new File("src/message.xml"));
        Element rootElement = document.getRootElement();

        List<Element> person = rootElement.elements("user");
        List<UserMessage> prsonData = new ArrayList<>();
        for (int i = 0; i <person.size(); i++) {
            Element ele = person.get(i);

            UserMessage user = new UserMessage();
            Attribute name = ele.attribute("userName");

            String value = name.getValue();
            user.setName(value);

            Element usNa = ele.element("usNa");
            Element passWord = ele.element("passWord");
            Element name1 = ele.element("name");
            String text = usNa.getText();
            String text1 = passWord.getText();
            String text2 = name1.getText();

            user.setUserName(text);
            user.setUserPassWord(text1);
            user.setName(text2);

            prsonData.add(user);


        }
        System.out.println(prsonData);
        return prsonData;
    }



}
