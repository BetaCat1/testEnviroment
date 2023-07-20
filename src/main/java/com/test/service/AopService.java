package com.test.service;

import com.test.annotation.MyAnnotation;
import org.springframework.stereotype.Component;



@Component

public class AopService {
    @MyAnnotation
    public String show(String name ) {
        System.out.println(name);

        return name;
    }

}
