package com.kaede.chapter08;

/**
 * -Xms10m ��ʼ���Ѵ�С10MB
 * -Xmx10m ���Ѵ�С20MB 
 */

public class HeapDemo1 {
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
