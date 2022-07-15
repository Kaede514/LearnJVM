package com.kaede.chapter16;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        //构造了弱引用
        WeakReference<User> uReference = new WeakReference<WeakReferenceTest.User>(new User(1, "kaede"));
        //从弱引用中重新获取对象
        System.out.println(uReference.get());
        System.gc();
        //不管当前内存空间是否足够，都会回收它的内存
        System.out.println("After GC:");
        System.out.println(uReference.get());
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
