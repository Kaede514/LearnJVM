package com.kaede.chapter02;

@SuppressWarnings("all")
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "��ʼ");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "����");
        };

        Thread t1 = new Thread(r, "�߳�1");
        Thread t2 = new Thread(r, "�߳�2");

        t1.start();
        t2.start();
    }  
}

class DeadThread {
    static {
        if(true) {
            System.out.println(Thread.currentThread().getName() + "��ʼ����ǰ��");
            //��̬��ʼ��������ļ�����ִֻ��һ�Σ����Ҵ������������̱߳���ȴ�ǰ���̷߳��ʳ�ʼ������ܽ��з��ʳ�ʼ��
            //���������ע�͵�while��t1���޷�ִ�У��ȴ�t2ִ�н���
            // while(true) {

            // }
        }
    }
}
