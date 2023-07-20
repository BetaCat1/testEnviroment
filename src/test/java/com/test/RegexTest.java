package com.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
