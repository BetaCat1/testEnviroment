package com.test.controller;

import com.test.exception.AgeException;
import com.test.service.TestFinalService;
import com.test.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

}
