package com.kaede.chapter13;

/**
 * 题目：new String("ab")会创建几个对象，看字节码可知为2个
 *      一个对象时：new关键字在堆空间中创建的
 *      另一个对象是：字符串常量池中的对象，字节码指令:ldc
 * 
 * new String("a") + new String("b")呢？
 *  对象1：new StringBuilder()
 *  对象2：new String("a")
 *  对象3：字符串常量池中的"a"
 *  对象4：new String("b")
 *  对象5：字符串常量池中的"b"
 * 深入剖析StringBuilder的toString()：
 *  对象6：new String("ab") （其中使用的是字符数组的String构造器，不是字符串字面量，故不会放入常量池中）
 *  强调一下：toString()方法的调用，在字符串常量池中没有生成"ab"
 */

public class StringNewTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String str1 = new String("ab");

        String str2 = new String("a") + new String("b");
    }
}
