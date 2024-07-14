package com.test;

import org.junit.jupiter.api.Test;

import javax.net.ssl.HttpsURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegexTest {



    @Test
    public void testMain1() {
        String regex = "(?=M)";
        String content1 = "Mary";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(content1);
        while(m.find()) {
            System.out.println(m.group());
            System.out.print("start:"+m.start());
            System.out.println(" end:"+m.end());
        }
    }

    @Test
    public void testMain2() {
        Pattern p=Pattern.compile("(?<=a)(\\d+)");
        Matcher m=p.matcher("aaa2223bb");
        System.out.println(m.find());//true
        System.out.println(m.groupCount());//2
        System.out.println(m.start(1));//0
        System.out.println(m.start(2));//6
        System.out.println(m.end(1));//6
        System.out.println(m.end(2));//7
        System.out.println(m.group(1));//aaa222
        System.out.println(m.group(2));//3
        System.out.println(m.group());//和group(0)的结果是一样的，就是输出匹配到的整个子串
    }


    @Test
    public void testMain3() {
        try {
            URL url = new URL("https://tenapi.cn/v2/toutiaohot");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
//            String userAgent="Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)";
//            conn.setRequestProperty("User-agent",userAgent);
            conn.addRequestProperty("User-Agent", "Apifox/1.0.0 (https://www.apifox.cn)"); // add this line to your code
            conn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testMain4() {
        System.out.println("hello world");
    }
}

