package com.kaede.chapter13;

/**
 * 总结String的intern()的使用：
 * jdk6中：将这个字符串尝试放入池中
 *        如果池中有，则不会放入，返回已有的池中的对象的地址
 *        如果没有，则会把此对象复制一份，放入池中，并返回池中的对象地址
 * jdk7起：将这个字符串尝试放入池中
 *        如果池中有，则不会放入，返回已有的池中的对象的地址
 *        如果没有，则会把此对象的引用地址复制一份，放入池中，并返回池中的引用地址
 */

public class StringIntern {
    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();//调用此方法之前，字符串常量池中已经存在"1"
        String s2 = "1";
        System.out.println(s1 == s2);   //jdk6:false    jdk7/8:false

        //s3变量记录的地址为new String("11")
        String s3 = new String("1") + new String("1");
        //执行完上一行代码后，字符串常量池中不存在"11"
        s3.intern();//在常量池中生成"11"
        //如何理解：jdk6：创建了一个新的对象"11"，也就有新的地址
        //         jdk7：此时常量池中没有创建"11"，而是创建一个指向堆空间中new String("11")的地址
        //对应jdk7/8，梳理：直接new String("x")会创建一个堆中对象，并在字符串常量池中创建一个对象
        //                 使用intern()方法若发现字符串常量池中未创建该字面量的对象则创建，创建了则不会再创建，最后返回地址
        String s4 = "11";//使用的是上一个代码执行时，在常量池中生成的"11"的地址
        System.out.println(s3 == s4);   //jdk6:false    jdk7/8:true

        String s5 = new String("2") + new String("3");
        //执行完上一行代码以后，字符串常量池中不存在"23"
        String s6 = "23";//在字符串常量池中生成对象"23"
        String s7 = s5.intern();//返回字符串常量池中的"23"地址
        System.out.println(s5 == s6);   //false
        System.out.println(s7 == s6);   //true
    }
}
