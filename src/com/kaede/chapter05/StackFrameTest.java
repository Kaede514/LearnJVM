package com.kaede.chapter05;

/**
 * ����java -Xss1024 StackFrameTest��ָ������ʱ��ջ�ռ��С���ڿ���̨
 * ����ע�͵����ĳ���Ȼ�����У�Ĭ��Ϊ�ֽڣ�������k,m,g�ȵ�λ
 */

public class StackFrameTest {
    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        stackFrameTest.method1();
        // return; ���ڣ���������һ��ջ֡��������д������ʡ��
    }

    public void method1() {
        System.out.println("method1()��ʼִ��...");
        try {
            method2();      
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("method1()ִ�н���...");
    }

    public int method2() {
        System.out.println("method2()��ʼִ��...");
        int i = 10;
        int m = (int) method3();
        // System.out.println(10 / 0);
        System.out.println("method2()��������...");
        return i + m;
    }

    public double method3() { 
        System.out.println("method3()��ʼִ��...");
        double j = 20.0;
        method4();
        System.err.println("method3()��������...");
        return j;
    }

    //������javap -v .\StackFrameTest.class������˽�з���������ʹ��javap -p .\StackFrameTest.class��ʾ��˽�з���    
    private void method4() {
        System.out.println("method4()��ʼִ��...");
        System.err.println("method4()ִ�н���...");
    }
}
