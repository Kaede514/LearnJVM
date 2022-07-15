package com.kaede.chapter08;

/**
 * 栈上分配测试（逃逸分析默认开启）
 * -Xms1g -Xmx1g -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * -Xms1g -Xmx1g -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * 改为256m后由于空间大小不足发生了MinorGC
 * 
 * 本例中，未开启逃逸分析时对象分配在堆空间，花费的时间为：60ms
 *         开启逃逸分析时对象分配在栈上，花费的时间为：4ms
 */

public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for(int i = 0; i < 10000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
        //方便查看内存中对象个数，线程sleep
        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("all")
    private static void alloc() {
        User user = new User(); //未发生逃逸
    }

    static class User {

    }
}
