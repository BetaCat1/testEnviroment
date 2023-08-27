package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.exception.AgeException;
import com.test.pojo.Client;
import com.test.pojo.User;
import com.test.pojo.User1;
import com.test.service.TestFinalService;
import com.test.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {


    private final TestFinalService testFinalService;

    @Qualifier("ka")
    private final Strategy ka;

    private int a = 0;
    @GetMapping(value = "/Repaired")
    public synchronized String getTicketsRepaired(){
        a++;
        System.out.println(Thread.currentThread().getName());
        new Thread(
                ()->{

                    System.out.println(Thread.currentThread().getName());
                }
        ).start();
        return "hello world";
    }

    @GetMapping(value = "/final")
    public  String getFinal(){

        return testFinalService.show();
    }



    @GetMapping(value = "/exception/{age}")
    public  String getAge(@PathVariable("age") Integer age) {

        try {
            if(age<0){
                throw new AgeException("年龄异常，age："+age);
            }
            System.out.println("程序继续运行");
        } catch (AgeException e) {
            e.printStackTrace();
        }


        return "程序继续运行";
    }


    @GetMapping(value = "/rest")
    public  User getrest( ) {

        Client c = new Client();
        User1 user1 = new User1();
        user1.setClient(c);
        User user = new User();
        List<User1> u = new ArrayList<>();
        u.add(user1);
        user.setUser1s(u);

        return user;
    }



    @GetMapping(value = "/rest")
    public  String getrestTem( ) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<User> exchange = rest.exchange("http://192.168.31.48:8080/api/final", HttpMethod.GET, HttpEntity.EMPTY, User.class);
        String x = JSON.toJSONString(exchange);
        System.out.println(x);
        return x;
    }






}
