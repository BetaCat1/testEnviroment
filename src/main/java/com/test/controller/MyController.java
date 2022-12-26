package com.test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping(value = "/Repaired")
    public String getTicketsRepaired(){
        return "hello world";
    }

}
