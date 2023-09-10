package com.test.service;

import lombok.Data;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@Data
@EnableAsync
public class ThreadException {


    @Async
    public void exception() {
        System.out.println("子线程："+Thread.currentThread().getName());
        throw new RuntimeException("线程异常");


    }


}
