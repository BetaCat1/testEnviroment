package com.test.controller;

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
        System.out.println(a);
        return "hello world";
    }

    @GetMapping(value = "/final")
    public  String getFinal(){

        return testFinalService.show();
    }

}
