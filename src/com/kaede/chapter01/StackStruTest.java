package com.kaede.chapter01;

/**
 * �������ֽ����Ŀ¼��cd .\bin\com\kaede\chapter01\
 * ִ�з����룬javap -v .\StackStruTest.class
 * ��ʾ����Ϣ��javap -p xxx
 * �������ࣨ����˽�з��������ԣ�javap -v -p xxx
 * 
 * JVM��Javaָ�����ջ����ƣ���ƽ̨�Ժš�ָ�С��ָ��࣬��ִ�����ܱȼĴ�����
 */

public class StackStruTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // int i = 2 +3;
        int i = 2;
        int j = 3;
        int k = i + j;
    }
}
