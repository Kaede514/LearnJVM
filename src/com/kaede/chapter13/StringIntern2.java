package com.kaede.chapter13;

import org.junit.Test;

/**
 * intern()的效率测试
 * 
 * 结论：对于程序中大量存在存在的字符串，尤其其中存在很多的字符串时，使用intern()可以节省内存空间
 *      如社交网站存储地址信息北京省、海淀区
 */

public class StringIntern2 {
    private static final int MAX_COUNT = 1000 * 10000;
    private static final String[] arr = new String[MAX_COUNT];

    @Test
    public void test1() {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();
        for(int i = 0; i < MAX_COUNT; i++) {
            arr[i] = new String(String.valueOf(data[i % data.length]));
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));   //9611ms
    }

    @Test
    public void test2() {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();
        for(int i = 0; i < MAX_COUNT; i++) {
            arr[i] = new String(String.valueOf(data[i % data.length])).intern();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));   //2568ms
    }
}
