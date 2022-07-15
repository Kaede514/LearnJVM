package com.kaede.chapter16;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

@SuppressWarnings("all")
public class PhantomReferenceTest {
    private static PhantomReferenceTest obj;
    public static ReferenceQueue<PhantomReferenceTest> rq = null;   //引用队列

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);  //设为守护线程
        t.start();

        rq = new ReferenceQueue<>();
        obj = new PhantomReferenceTest();
        //构造了 PhantomReferenceTest 的虚引用，并指定了引用队列
        PhantomReference<PhantomReferenceTest> pref = new PhantomReference<PhantomReferenceTest>(obj, rq);
        try {
            //不可获取虚引用中的对象
            System.out.println(pref.get());

            //将引用去除
            obj = null;
            //第一次进行GC，由于对象可复活，GC无法回收该对象
            System.gc();    //一旦将obj回收，就会将此虚引用存放到引用队列中
            Thread.sleep(1000);     
            if(obj == null) {
                System.out.println("obj == null");
            } else {
                System.out.println("obj 可用");
            }
            System.out.println("第二次GC");
            obj = null;
            System.gc();   
            Thread.sleep(1000);
            if(obj == null) {
                System.out.println("obj == null");
            } else {
                System.out.println("obj 可用");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static class CheckRefQueue extends Thread {
        @Override 
        public void run() {
            while(true) {
                if(rq != null) {
                    PhantomReference<PhantomReferenceTest> objt = null;
                    try {
                        objt = (PhantomReference<PhantomReferenceTest>) rq.remove();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    if(objt != null) {
                        System.out.println("追踪垃圾回收过程：PhantomReferenceTest实例被GC了");
                    }
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类的finalize()方法");
        obj = this;
    }
}
