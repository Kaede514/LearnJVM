package com.kaede.chapter16;

import java.lang.ref.SoftReference;

/**
 * �����ò��ԣ��ڴ治��ʱ���գ�����OOMǰһ������գ�
 * java -Xms10m -Xmx10m SoftReferenceTest
 */

@SuppressWarnings("all")
public class SoftReferenceTest {
    public static void main(String[] args) {
        //�������󣬽���������
        // SoftReference<User> uReference = new SoftReference<User>(new User(1, "kaede"));
        //�ȼ�������
        User u = new User(1, "kaede");
        SoftReference<User> uReference = new SoftReference<User>(u);
        u = null;

        //�����������»��ǿ���ö���
        System.out.println(uReference.get());

        //��Ϊ�ѿռ��㹻���ʲ�����������õĿɴ����
        System.gc();
        System.out.println("After GC:");
        System.out.println(uReference.get());

        try {
            //��ϵͳ��Ϊ�ڴ���Դ����
            byte[] b = new byte[1024 * 1024 * 7];
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            //�ڱ�OOMǰ����������������������õĿɴ����
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
