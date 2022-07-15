package com.kaede.chapter02;

public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
    }

    private static int number = 10; //linking֮prepare: number = 0 --> initial: 20 --> 10

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
