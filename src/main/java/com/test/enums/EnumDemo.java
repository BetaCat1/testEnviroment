package com.test.enums;

import java.util.*;

public class EnumDemo {

    public static void main(String[] args){

        Day day =Day.MONDAY;
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("b");

        for (String str : data) {
            System.out.println(str);
        }
        Enum e = Day.MONDAY;
    }

}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}