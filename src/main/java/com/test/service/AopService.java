package com.test.service;

import org.springframework.stereotype.Component;

@Component
public class AopService {

    public String show(String name ) {
        System.out.println(name);

        return name;
    }

}
