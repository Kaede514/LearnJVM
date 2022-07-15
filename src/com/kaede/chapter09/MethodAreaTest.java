package com.kaede.chapter09;

/**
 * 测试设置方法区大小参数的设置
 * windows下，-XX:MetaspaceSize是21M，-XX:MaxMetaspaceSize的值是-1，即没有限制
 * 
 * jdk7及以前：
 * -XX:PermSize=100M  -XX:MaxPermSize=100m
 * 
 * jkd8及以后：
 * -XX:MetaspaceSize=100m  -XX:MaxMetaspaceSize=100m
 * 查看：jinfo -flag MetaspaceSize 进程id   jinfo -flag MaxMetaspaceSize 进程id
 * 建议Metaspace设置相对较高，防止频繁进行GC影响性能
 */

public class MethodAreaTest {
    public static void main(String[] args) {
        System.out.println("start...");

        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
