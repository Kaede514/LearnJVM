package com.kaede.chapter08;

/**
 * -Xms10m 初始化堆大小10MB
 * -Xmx10m 最大堆大小20MB 
 */

public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            //休眠1000s
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
