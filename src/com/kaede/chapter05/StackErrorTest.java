package com.kaede.chapter05;

public class StackErrorTest {
    private static int count = 1;

    public static void main(String[] args) {
        //java.lang.StackOverflowError
        System.out.println(count);
        count++;
        main(args);
    }
}
