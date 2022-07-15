package com.kaede.chapter08;

/**
 * 同步省略说明
 */

public class SynchronizedTest {
    public void f() {
        Object hollis = new Object();
        //运行时会变为 System.out.println(hollis);
        synchronized(hollis) {
            System.out.println(hollis);
        }
    }
}
