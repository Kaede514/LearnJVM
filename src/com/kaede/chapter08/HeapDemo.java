package com.kaede.chapter08;

/**
 * -Xms10m ��ʼ���Ѵ�С10MB
 * -Xmx10m ���Ѵ�С10MB 
 */

public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            //����1000s
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
