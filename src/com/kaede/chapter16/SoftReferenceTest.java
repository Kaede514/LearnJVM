package com.kaede.chapter16;

import java.lang.ref.SoftReference;

/**
 * 软引用测试（内存不足时回收，发生OOM前一定会回收）
 * java -Xms10m -Xmx10m SoftReferenceTest
 */

@SuppressWarnings("all")
public class SoftReferenceTest {
    public static void main(String[] args) {
        //创建对象，建议软引用
        // SoftReference<User> uReference = new SoftReference<User>(new User(1, "kaede"));
        //等价于以下
        User u = new User(1, "kaede");
        SoftReference<User> uReference = new SoftReference<User>(u);
        u = null;

        //从软引用重新获得强引用对象
        System.out.println(uReference.get());

        //因为堆空间足够，故不会回收软引用的可达对象
        System.gc();
        System.out.println("After GC:");
        System.out.println(uReference.get());

        try {
            //让系统认为内存资源紧张
            byte[] b = new byte[1024 * 1024 * 7];
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            //在报OOM前，垃圾回收器会回收软引用的可达对象
            System.out.println(uReference.get());
        }
    }

    private static class User {
        private int id;
        private String name;
        
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    
        @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + "]";
        }    
    }
}
