package com.kaede.chapter08;

/**
 * ͬ��ʡ��˵��
 */

public class SynchronizedTest {
    public void f() {
        Object hollis = new Object();
        //����ʱ���Ϊ System.out.println(hollis);
        synchronized(hollis) {
            System.out.println(hollis);
        }
    }
}
