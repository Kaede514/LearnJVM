package com.kaede.chapter02;

@SuppressWarnings("all")
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
    }  
}

class DeadThread {
    static {
        if(true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            //静态初始化块在类的加载中只执行一次，并且存在锁，单个线程必须等待前个线程访问初始化完才能进行访问初始化
            //这里如果不注释掉while，t1将无法执行，等待t2执行结束
            // while(true) {

            // }
        }
    }
}
