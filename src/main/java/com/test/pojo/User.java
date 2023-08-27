package com.test.pojo;

import lombok.Data;

import java.util.*;

@Data
public class User<T> {

    private String name = "朱卫东";
    private Integer age=3;

    private List<T> User1s;




}
