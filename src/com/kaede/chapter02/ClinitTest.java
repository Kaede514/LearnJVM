package com.kaede.chapter02;

@SuppressWarnings("all")
public class ClinitTest {
    //�κ�һ���������Ժ��ڲ����ٴ���һ����ļ�����
    private int a = 1;
    private static int c = 3;

    public static void main(String[] args) {
        int b = 2;
    }

    public ClinitTest() {
        a = 10;
        int d = 20;
    }
}
