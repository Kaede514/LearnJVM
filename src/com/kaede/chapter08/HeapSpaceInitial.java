package com.kaede.chapter08;

/**
 * 1、设置堆空间大小的参数
 * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
 *      -X 是jvm 的运行参数
 *      ms 是 memory start
 * -Xmx 用来设置堆空间的最大内存大小
 * 
 * 2、默认堆空间的大小
 *      初始内存大小：物理电脑内存大小 / 64
 *      最大内存大小：物理电脑内存大小 / 4
 * 
 * 3、手动设置 -Xms600M -Xmx600 M 
 *      开发中建议初始堆内存和最大堆内存设置成一样，防止GC频繁释放分配堆内存，影响运行
 * 
 * 4、查看设置的参数：方式一：jps / jstat -gc 进程id
 *                  方式二：-XX:+PrintGCDetails
 */

public class HeapSpaceInitial {
    public static void main(String[] args) {
        //返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回Java虚拟机驶入使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms: " + initialMemory + "M");
        System.out.println("-Xmm: " + maxMemory + "M");

        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");

        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
