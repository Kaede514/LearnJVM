package com.kaede.chapter13;

import org.junit.Test;

/**
 * String类型为不可变的
 * 里面很多有返回值的方法都是直接返回一个新对象，而不是本身（即this）
 */

public class StringTest {
    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s1 += "def";

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');

        System.out.println(s1);
        System.out.println(s2);
    }
}
