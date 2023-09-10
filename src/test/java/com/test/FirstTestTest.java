package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.controller.Student;
import com.test.pojo.User;
import com.test.pojo.User1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.*;
import java.util.stream.IntStream;

public class FirstTestTest  {
@Test
    public void testMain() {
    Pattern p=Pattern.compile("(\\d*)");
    Matcher m=p.matcher("");
    String s = m.replaceAll("");
    System.out.println(m.matches());
    System.out.println(s);
    }

    @Test
    public void testMain1() {
        List list = new ArrayList();
            list.add("123");
            List<Integer>  list2 = list;
            System.out.println(list2.get(0).intValue());
    }

    @Test
    public void testBeanUtils() {
        User soure = new User();
        soure.setName("1");
        List<User> userList = new ArrayList<User>();
        userList.add(soure);
//        User1 target = new User1();
        List<User1> user1List = new ArrayList<User1>();
//        user1List.add(target);
        userList.forEach(l->{
            User1 target = new User1();
            BeanUtils.copyProperties(l, target);
            user1List.add(target);
        });
//        BeanUtils.copyProperties(userList, user1List);
//        System.out.println(target);
        System.out.println(user1List);
    }


    @Test
    public void testThread() {
        new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            while (true) {
                System.out.println("新线程运行中");
            }
        }).start();
        while (true) {
//            Thread.sleep(2000);
            System.out.println("主线程运行");
//                Thread.sleep(2000);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        List list = new ArrayList();
        list.add(1);
        list.add("1212");

        for (Object str:list) {
            Object obj = str;
            service.execute(()->{
                if("pool-1-thread-2".equals(Thread.currentThread().getName())){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(testFunction(1));
            });
        }
        service.shutdown();
    }

    public static String testFunction(int i){
        if (i ==0){
            return Thread.currentThread().getName()+"输入是0";
        }else {
            return Thread.currentThread().getName()+"输入是非0";
        }
    }



    @Test
    public void testFastJson() {

        User user = new User();
        user.setName("111");
        user.setAge(111);
        String s = JSON.toJSONString(user,true);
        System.out.println(s);

        Object user1 = JSON.parseObject(s);
        System.out.println(user1);

        User1 user3 = JSON.parseObject(s, User1.class);
        System.out.println("user3"+user3);
        Object o = JSON.toJSON(user3);
        JSON.toJavaObject((JSON)o, User1.class);
        System.out.println("Object:  "+o);

        Object parse = JSON.parse(s);
        JSONObject jsonObject = (JSONObject) parse;
        User user2 = jsonObject.toJavaObject(User.class);
        System.out.println(user2);

        List<User> input = new ArrayList<>();
        input.add(user2);
        String s1 = JSON.toJSONString(input);
        System.out.println(s1);
        JSONArray objects = JSON.parseArray(s1);
        System.out.println(objects);
    }



    @Test
    @DisplayName("JSON.toJSONString确实会让字符串首尾多了双引号")
    public void testJsonToString() {
        String example = "{\\n\" +\n" +
                "                \"    \\\"result\\\": \\\"\\\",\\n\" +\n" +
                "                \"    \\\"creditId\\\": \\\"\\\",\\n\" +\n" +
                "                \"    \\\"pageSize\\\": 10,\\n\" +\n" +
                "                \"    \\\"tabNumber\\\": \\\"\\\",\\n\" +\n" +
                "                \"    \\\"creditStatus\\\": \\\"\\\",\\n\" +\n" +
                "                \"    \\\"customerName\\\": \\\"\\\",\\n\" +\n" +
                "                \"    \\\"page\\\": 1\\n\" +\n" +
                "                \"}";
        System.out.println(example);
        System.out.println(JSON.toJSONString(example));
    }
}