package com.test;

import com.test.service.AopService;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPoolTest {


    @Test
    public void testMain1() {
        String a =new String(new char[]{'a','b','c'});//相当于String a ="abc";不一样，
//String a ="abc"永远是相等的，但这种方式只有第一次创建的对象会进入字符创常量池
        String b = new String(new char[]{'a','b','c'});
//        String c = "abc";
//         b = a.intern();
        System.out.println(a ==a.intern());//true
        System.out.println(a ==b);//false
//        System.out.println(a ==c);//false
        }

    @Test
    public void testMain2() {
        String a = new String("abc");//相当于String a ="abc";不一样，
        String b = new String(a);
        System.out.println(a==b);
    }

    @Test
    public void testMain3() {
        String a =new String(new char[]{'a','b','c'});//这个不在常量池
        String b = "abc";
        System.out.println(a ==a.intern());//false
        System.out.println(a==b);//false
        System.out.println(b ==a.intern());//true
    }

    @Test
    public void testMain4() {
        String a =new String(new char[]{'a','b','c'});//这个在常量池
        System.out.println(a ==a.intern());//true
        String b = "abc";
        System.out.println(a==b);//true
        System.out.println(b ==a.intern());//true
    }

    @Test
    public void testMain5() {
        String a =new String(new byte[]{58,59,60});//这个在常量池
        System.out.println(a);
        String b = ":;<";
        System.out.println(a ==a.intern() );//true
        System.out.println(a==b);//true
        System.out.println(b ==a.intern());//true
    }

    @Test
    public void testMain6() {
        String m1 = "ja";
        String m2 = "va1";
        String m = m1 + m2;
//        String n = new String(new char[]{'j', 'a', 'v', 'a'});
//        System.out.println(n.intern() == n);
        System.out.println(m == m.intern());//false
        System.out.println(m.intern() );
    }

    @Test
    public void testMain7() {
        String m = "ja" + "va";
        String n = new String(new char[]{'j', 'a', 'v', 'a'});
        System.out.println(n.intern() == n);
    }

    @Test
    public void testMain8() {
        String d= "d";
        String x ="abc";
//        String z ="abc";
//        String y = "abc";
        x =x+ d;
        String z =d+ x;
//        y =y+ d;
        System.out.println(x == x.intern());//true首次创建进入字符串常量池，说明拼接是创建新对象实现的
//        System.out.println(y == y.intern());//false
        System.out.println(z == z.intern());//true
//        System.out.println(x);
//        System.out.println(y);
        System.out.println(z.intern());
    }

    @Test
    public void testMain() {
        String s1 = "abc";
        String s2 = "def";
        String s3 = new String(s1+s2);
//        String s4 = "abcdef";
//        System.out.println(s3==s4); // false
        System.out.println(s3==s3.intern()); // false
    }

    @Test
    public void testMain10() {
//        String s1 = "abc";
//        String s2 = "def";
        String s3 = new String("abc"+"def");
        System.out.println(s3==s3.intern()); // false
    }

    @Test
    public void testMain11() {
        String a =new String(new char[]{'a','b','c'});
        String b =new String(new char[]{'a','b','c'});
        System.out.println(a==b); // false
        System.out.println(a==a.intern()); // false
        System.out.println(b==a.intern()); // false
        System.out.println(b==b.intern()); // false
        System.out.println(a.intern()==b.intern()); // true
    }

    @Test
    public void testMain12() {
        AopService a = new AopService();
        System.out.println(a instanceof Object);
    }
}

