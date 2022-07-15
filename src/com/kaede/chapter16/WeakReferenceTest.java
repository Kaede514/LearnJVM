package com.kaede.chapter16;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        //������������
        WeakReference<User> uReference = new WeakReference<WeakReferenceTest.User>(new User(1, "kaede"));
        //�������������»�ȡ����
        System.out.println(uReference.get());
        System.gc();
        //���ܵ�ǰ�ڴ�ռ��Ƿ��㹻��������������ڴ�
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
