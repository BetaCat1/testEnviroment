package com.test.service;

import com.test.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TestFinalService {

    private final Map<String, Strategy> strategy ;

    public String show(){
        System.out.println(strategy);
        return "hello world";
    }
}
