package com.kaede.chapter08;

/**
 * ջ�Ϸ�����ԣ����ݷ���Ĭ�Ͽ�����
 * -Xms1g -Xmx1g -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * -Xms1g -Xmx1g -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * ��Ϊ256m�����ڿռ��С���㷢����MinorGC
 * 
 * �����У�δ�������ݷ���ʱ��������ڶѿռ䣬���ѵ�ʱ��Ϊ��60ms
 *         �������ݷ���ʱ���������ջ�ϣ����ѵ�ʱ��Ϊ��4ms
 */

public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for(int i = 0; i < 10000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start) + "ms");
        //����鿴�ڴ��ж���������߳�sleep
        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("all")
    private static void alloc() {
        User user = new User(); //δ��������
    }

    static class User {

    }
}
