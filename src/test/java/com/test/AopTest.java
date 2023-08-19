package com.test;

import com.test.service.AopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class AopTest {

    @Autowired
    AopService aopService;

    @Test
    public void testAop() {
//        aopService.show("测试本地方法");
        aopService.getName1();

    }



}
