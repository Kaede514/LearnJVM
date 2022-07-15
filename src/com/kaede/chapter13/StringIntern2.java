package com.kaede.chapter13;

import org.junit.Test;

/**
 * intern()��Ч�ʲ���
 * 
 * ���ۣ����ڳ����д������ڴ��ڵ��ַ������������д��ںܶ���ַ���ʱ��ʹ��intern()���Խ�ʡ�ڴ�ռ�
 *      ���罻��վ�洢��ַ��Ϣ����ʡ��������
 */

public class StringIntern2 {
    private static final int MAX_COUNT = 1000 * 10000;
    private static final String[] arr = new String[MAX_COUNT];

    @Test
    public void test1() {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();
        for(int i = 0; i < MAX_COUNT; i++) {
            arr[i] = new String(String.valueOf(data[i % data.length]));
        }
        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));   //9611ms
    }

    @Test
    public void test2() {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();
        for(int i = 0; i < MAX_COUNT; i++) {
            arr[i] = new String(String.valueOf(data[i % data.length])).intern();
        }
        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));   //2568ms
    }
}
