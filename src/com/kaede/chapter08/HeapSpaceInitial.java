package com.kaede.chapter08;

/**
 * 1�����öѿռ��С�Ĳ���
 * -Xms �������öѿռ䣨�����+��������ĳ�ʼ�ڴ��С
 *      -X ��jvm �����в���
 *      ms �� memory start
 * -Xmx �������öѿռ������ڴ��С
 * 
 * 2��Ĭ�϶ѿռ�Ĵ�С
 *      ��ʼ�ڴ��С����������ڴ��С / 64
 *      ����ڴ��С����������ڴ��С / 4
 * 
 * 3���ֶ����� -Xms600M -Xmx600 M 
 *      �����н����ʼ���ڴ�������ڴ����ó�һ������ֹGCƵ���ͷŷ�����ڴ棬Ӱ������
 * 
 * 4���鿴���õĲ�������ʽһ��jps / jstat -gc ����id
 *                  ��ʽ����-XX:+PrintGCDetails
 */

public class HeapSpaceInitial {
    public static void main(String[] args) {
        //����Java������еĶ��ڴ�����
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //����Java�����ʻ��ʹ�õ������ڴ���
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms: " + initialMemory + "M");
        System.out.println("-Xmm: " + maxMemory + "M");

        System.out.println("ϵͳ�ڴ��СΪ��" + initialMemory * 64.0 / 1024 + "G");
        System.out.println("ϵͳ�ڴ��СΪ��" + maxMemory * 4.0 / 1024 + "G");

        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
