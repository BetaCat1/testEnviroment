package com.test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    private int a = 0;
    @GetMapping(value = "/Repaired")
    public String getTicketsRepaired(){
        a++;
        System.out.println(a);
        return "hello world";
    }

}
