package com.lanou3g.tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class JSONManage {
    //查询天气
    public static void  Tq(String cs) throws IOException {

        String city = java.net.URLEncoder.encode(cs, "utf-8");
        String c = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s", city);

        URL url = new URL(c);
        InputStream coon = url.openStream();

        //获得网络连接中的流
        //然后再从流中获得数据
        ByteArrayOutputStream out = new ByteArrayOutputStream();


        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = coon.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if (coon != null) {
                coon.close();
            }
        }

        byte[] b = out.toByteArray();
        // System.out.print(new String(b,"UTF-8") );
        String str = new String(b);

        JSONObject jsonObject = JSONObject.fromObject(str);

        TqClass tq = (TqClass) JSONObject.toBean(jsonObject, TqClass.class);

        System.out.println("城市为" + tq.getCity() + "\n时间为" + tq.getDate()+  "\n温度为" + tq.getData().getWendu() + "\n湿度为:" + tq.getData().getShidu() +
                "\n建议:" + tq.getData().getGanmao());

    }




    //查询归属地
    public static void phone(String phone) throws IOException {

        String city = java.net.URLEncoder.encode(phone, "utf-8");
        String c = String.format("https://www.iteblog.com/api/mobile.php?mobile=%s", city);

        URL url = new URL(c);
        InputStream coon = url.openStream();

        ByteArrayOutputStream out = new ByteArrayOutputStream();


        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = coon.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if (coon != null) {
                coon.close();
            }
        }

        byte[] b = out.toByteArray();
        // System.out.print(new String(b,"UTF-8") );
        String str = new String(b);


        JSONObject jsonObject = JSONObject.fromObject(str);

        PhoneClass ph = (PhoneClass) JSONObject.toBean(jsonObject, PhoneClass.class);

        System.out.println("手机号前七位是" + ph.getPrefix()+"\n手机号归属地" + ph.getCity()+"\n运营商:"+ph.getOperator());
        //t+ "\n归属地为" + ph.getProvince() + "\n运营商为" + ph.getCarrier());


    }
    @Test
    public static   void inquiry() throws IOException {

        URL url = new URL("http://192.168.20.194:8080/day16/ten");

        InputStream coon = url.openStream();



        ByteArrayOutputStream out = new ByteArrayOutputStream();



            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = coon.read(buf)) > 0) {
                out.write(buf, 0, read);

        }
            if (coon != null) {
                coon.close();
            }


        byte[] b = out.toByteArray();

        String str = new String(b);
        JSONArray array = JSONArray.fromObject(str);

        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            System.out.println("第"+ (i+1) +"名"+jsonObject.get("nickname") + "时间为:" + jsonObject.get("score") );

        }



        System.out.println(str);

    }










}



