package com.test.service;

import com.test.annotation.MyAnnotation;
import lombok.Data;
import org.springframework.stereotype.Component;



@Component
@Data
public class AopService {

    private String name1;


//    public String show(String name ) {
//        System.out.println(name);
//
//        return name;
//    }

}
