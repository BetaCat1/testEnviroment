package com.test.algos;

public class ShouldPrivate {

    private String name;

    public ShouldPrivate(String name){
        this.name = name;
    }

    public String getOtherName(ShouldPrivate input) {
        return input.name;
    }
}
