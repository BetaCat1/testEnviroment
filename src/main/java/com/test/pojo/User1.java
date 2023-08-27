package com.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User1<T> {
    @JsonIgnore
    private Integer name =13;
    private T client;

//    public void setName(String name) {
//        this.name = name+"级部门";
//    }
}
