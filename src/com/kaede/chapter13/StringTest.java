package com.kaede.chapter13;

import org.junit.Test;

/**
 * String����Ϊ���ɱ��
 * ����ܶ��з���ֵ�ķ�������ֱ�ӷ���һ���¶��󣬶����Ǳ�����this��
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
