package com.test.controller;

public class Father {

    static final String STATIC_FIELD_01 = getFatherField("STATIC_FIELD_01");

    private String field01 = getMemberFatherField("field01");

    public Father() {
        System.out.println("父类构造方法！");
    }

    static {
        System.out.println("父类静态代码块！");
    }

    static final String STATIC_FIELD_02 = getFatherField("STATIC_FIELD_02");

    static String getFatherField(String str) {
        System.out.println("父类静态成员变量初始化-" + str);
        return str;
    }

    {
        System.out.println("父类代码块！");
    }

    private String field02 = getMemberFatherField("field02");

    String getMemberFatherField(String str) {
        System.out.println("父类成员变量初始化-" + str);
        return str;
    }

    static class Son extends Father {

        static final String STATIC_FIELD_01 = getSonField("STATIC_FIELD_01");

        private String field01 = getMemberSonField("field01");

        public Son() {
            System.out.println("子类构造方法！");
        }

        static {
            System.out.println("子类静态代码块！");
        }

        static final String STATIC_FIELD_02 = getSonField("STATIC_FIELD_02");

        static String getSonField(String str) {
            System.out.println("子类静态成员变量初始化-" + str);
            return str;
        }

        {
            System.out.println("子类代码块！");
        }

        private String field02 = getMemberSonField("field02");

        String getMemberSonField(String str) {
            System.out.println("子类成员变量初始化-" + str);
            return str;
        }
    }

    public static void main(String[] args) {
        new Son();
    }
}
