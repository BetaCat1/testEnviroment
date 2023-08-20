package com.test.controller;

import com.test.service.TestFinalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {


    private final TestFinalService testFinalService;

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
