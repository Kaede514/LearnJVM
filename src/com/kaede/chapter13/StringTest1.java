package com.kaede.chapter13;

import org.junit.Test;

public class StringTest1 {
    @Test
    public void test1() {
        String s1 = "a" + "b" + "c";    //编译期优化，等同于"abc"
        String s2 = "abc";  //"abc"一定是放在字符串常量池中，将此地址赋给s2
        /**
         * 最终.java编译为.class，再执行.class
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
        String s4 = "java" + "EE";  //编译期优化
        //如果拼接符号的前后出现了变量，则相当于再堆空间中new String()，具体的内容为拼接的结果：javaEE
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
        //intern():判断字符串常量池中是否存在javaEE值，如果存在，则返回常量池中javaEE的地址，
        //如果字符串常量池中不存在javaEE，则在常量池中加载一份javaEE，并返回此对象的地址
        String s8 = s6.intern();
        System.out.println(s3 == s8);   //true
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /**
         * 如下的s1 + s2执行细节：
         * （1）StringBuilder s = new StringBuilder();
         * （2）s.append("a");
         * （3）s.append("b");
         * （4）s.toString() -> 约等于new String("ab")
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4);   //false
    }

    /**
     * 字符串拼接操作不一定使用的是StringBuilder！
     * 如果拼接符号左右两侧都是字符串常量或者常量引用，则仍然使用编译期优化，并非StringBuilder的方式
     * 针对final修饰类、方法、基本数据类型、引用数据类型的量的结构时，能使用上final的时候建议用上   
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
     * 体会执行效率：通过StringBuilder的append()方式添加字符串的效率要远高于使用String的字符串拼接方式！
     * 详情：（1）StringBuilder的append()方式：自始至终值创建过一个StringBuilder对象
     *           使用String的字符串拼接方式：创建过多个StringBuilder和String对象
     *      （2）使用String的字符串拼接方式：内存中由于创建了较多的StringBuilder和String对象，内存占用更大，如果进行GC，需要花费额外时间
     * 
     * 改进的空间：在实际开发中，如果基本确定要前前后后添加的字符串长度不高于某个限定值highLevel的情况下，建议使用
     *            构造器 StringBuilder s = new StringBuilder(highLevel);//new char[highLevel]
     *            以免数组频繁进行扩容
     */
    @Test
    public void test6() {
        long start = System.currentTimeMillis();

        method1(100000);

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));   //5034ms
    }

    @Test
    public void test7() {
        long start = System.currentTimeMillis();

        method2(100000);

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));   //10ms
    }

    public void method1(int highLevel) {
        String src = "";
        for(int i = 0; i < highLevel; i++) {
            src = src + "a";    //每次操作都会创建一个StringBuilder和String
        }
    }

    public void method2(int highLevel) {
        //只需要创建一个StringBuilder
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
        System.out.println("花费的时间为：" + (end - start));   //8ms
    }

    public void method3(int highLevel) {
        //只需要创建一个StringBuilder
        StringBuilder src = new StringBuilder(highLevel);
        for(int i = 0; i < highLevel; i++) {
            src.append("a");   
        }
    }
}
