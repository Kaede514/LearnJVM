package com.kaede.chapter05;

/**
 * �����⣺
 * �����ж���ľֲ������Ƿ��̰߳�ȫ����������������
 *      ���ֻ��һ���̲߳ſ��Բ��������ݣ����Ȼ���̰߳�ȫ��
 *      ����ж���̲߳��������ݣ���������ǹ������ݣ����������ͬ�����ƵĻ���������̰߳�ȫ����
 */

public class StringBuilderTest {
    //s1��������ʽ���̰߳�ȫ��
    public static void method1() {
        //StringBuilder�̲߳���ȫ
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
    }

    //sBuilder�Ĳ������̣��̲߳���ȫ��
    public static void method2(StringBuilder sBuilder) {
        sBuilder.append("a");
        sBuilder.append("b");
    }

    //s1�Ĳ�����ʽ���̲߳���ȫ��
    public static StringBuilder method3() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        return s1;
    }

    //s1�Ĳ�����ʽ���̰߳�ȫ��
    public static String method4() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        //����һ���µĶ���
        return s1.toString();
    }
}
