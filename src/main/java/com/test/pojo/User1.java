package com.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User1 {
    @JsonIgnore
    private Integer name;

//    public void setName(String name) {
//        this.name = name+"级部门";
//    }
}
