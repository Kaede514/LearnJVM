package com.kaede.chapter08;

/**
 * 标量替换测试 
 * 将未发生逃逸的对象拆解为若干成员变量来替换（原始数据类型），不存储在内存，直接存储在CPU寄存器
 * -Xms100m -Xmx100m [-XX:+DoEscapeAnalysis] -XX:+PrintGC -XX:-EliminateAllocations
 * -Xms100m -Xmx100m [-XX:+DoEscapeAnalysis] -XX:+PrintGC
 * 
 * 本例中，关闭标量替换后，花费的时间为：55ms
 *        开启标量替换（默认）后，花费的时间为：3ms
 * 
 * 逃逸分析目前不成熟，hotspot只用了标量替换，没有实现栈上分配和同步省略
 * 
 * 对象实例都是分配在堆上的
 */

public class ScalarReplace {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for(int i = 0; i < 10000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
    }

    public static void alloc() {
        User u = new User();    //未发生逃逸
        u.id = 5;
        u.name = "kaede";
    }

    public static class User{
        public int id;
        public String name;
    }
}
