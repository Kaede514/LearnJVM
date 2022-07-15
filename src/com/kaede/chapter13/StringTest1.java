package com.kaede.chapter13;

import org.junit.Test;

public class StringTest1 {
    @Test
    public void test1() {
        String s1 = "a" + "b" + "c";    //�������Ż�����ͬ��"abc"
        String s2 = "abc";  //"abc"һ���Ƿ����ַ����������У����˵�ַ����s2
        /**
         * ����.java����Ϊ.class����ִ��.class
         * String s1 = "abc";
         * String s2 = "abc";
         */
        System.out.println(s1 == s2);   //true
        System.out.println(s1.equals(s2));  //true
    }

    @Test
    public void test2() {
        String s1 = "java";
        String s2 = "EE";

        String s3 = "javaEE";
        String s4 = "java" + "EE";  //�������Ż�
        //���ƴ�ӷ��ŵ�ǰ������˱��������൱���ٶѿռ���new String()�����������Ϊƴ�ӵĽ����javaEE
        String s5 = s1 + "EE";
        String s6 = "java" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);   //true
        System.out.println(s3 == s5);   //false
        System.out.println(s3 == s6);   //false
        System.out.println(s3 == s7);   //false
        System.out.println(s5 == s6);   //false
        System.out.println(s5 == s7);   //false
        System.out.println(s6 == s7);   //false
        //intern():�ж��ַ������������Ƿ����javaEEֵ��������ڣ��򷵻س�������javaEE�ĵ�ַ��
        //����ַ����������в�����javaEE�����ڳ������м���һ��javaEE�������ش˶���ĵ�ַ
        String s8 = s6.intern();
        System.out.println(s3 == s8);   //true
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /**
         * ���µ�s1 + s2ִ��ϸ�ڣ�
         * ��1��StringBuilder s = new StringBuilder();
         * ��2��s.append("a");
         * ��3��s.append("b");
         * ��4��s.toString() -> Լ����new String("ab")
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4);   //false
    }

    /**
     * �ַ���ƴ�Ӳ�����һ��ʹ�õ���StringBuilder��
     * ���ƴ�ӷ����������඼���ַ����������߳������ã�����Ȼʹ�ñ������Ż�������StringBuilder�ķ�ʽ
     * ���final�����ࡢ�����������������͡������������͵����Ľṹʱ����ʹ����final��ʱ��������   
     */
    @Test
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);   //true
    }

    @Test
    public void test5() {
        final String s1 = new String("a");
        final String s2 = new String("b");
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);   //false
    }

    /**
     * ���ִ��Ч�ʣ�ͨ��StringBuilder��append()��ʽ����ַ�����Ч��ҪԶ����ʹ��String���ַ���ƴ�ӷ�ʽ��
     * ���飺��1��StringBuilder��append()��ʽ����ʼ����ֵ������һ��StringBuilder����
     *           ʹ��String���ַ���ƴ�ӷ�ʽ�����������StringBuilder��String����
     *      ��2��ʹ��String���ַ���ƴ�ӷ�ʽ���ڴ������ڴ����˽϶��StringBuilder��String�����ڴ�ռ�ø����������GC����Ҫ���Ѷ���ʱ��
     * 
     * �Ľ��Ŀռ䣺��ʵ�ʿ����У��������ȷ��Ҫǰǰ�����ӵ��ַ������Ȳ�����ĳ���޶�ֵhighLevel������£�����ʹ��
     *            ������ StringBuilder s = new StringBuilder(highLevel);//new char[highLevel]
     *            ��������Ƶ����������
     */
    @Test
    public void test6() {
        long start = System.currentTimeMillis();

        method1(100000);

        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));   //5034ms
    }

    @Test
    public void test7() {
        long start = System.currentTimeMillis();

        method2(100000);

        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));   //10ms
    }

    public void method1(int highLevel) {
        String src = "";
        for(int i = 0; i < highLevel; i++) {
            src = src + "a";    //ÿ�β������ᴴ��һ��StringBuilder��String
        }
    }

    public void method2(int highLevel) {
        //ֻ��Ҫ����һ��StringBuilder
        StringBuilder src = new StringBuilder();
        for(int i = 0; i < highLevel; i++) {
            src.append("a");   
        }
    }

    @Test
    public void test8() {
        long start = System.currentTimeMillis();

        method3(100000);

        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));   //8ms
    }

    public void method3(int highLevel) {
        //ֻ��Ҫ����һ��StringBuilder
        StringBuilder src = new StringBuilder(highLevel);
        for(int i = 0; i < highLevel; i++) {
            src.append("a");   
        }
    }
}
