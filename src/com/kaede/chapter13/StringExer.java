package com.kaede.chapter13;

public class StringExer {
    public static void main(String[] args) {
        String s1 = new String("a") + new String("b");//new String("ab")
        //在上一行执行完以后，字符串常量中并没有"ab"
        String s2 = s1.intern();//jdk6中，在池中创建一个字符串"ab"
                                //jdk7起，池中没有创建字符串"ab"，二十创建一个执行new String("ab")的引用
        System.out.println(s1 == "ab");//jdk6:false jdk7:true
        System.out.println(s2 == "ab");//jdk6:true  jdk7:true

        String s3 = new String("cd");
        s3.intern();
        String s4 = "cd";
        System.out.println(s3 == s4);   //jdk6:false jdk7:false

        String s5 = new String("e") + new String("f");
        s5.intern();
        String s6 = "ef";
        System.out.println(s5 == s6);   //jdk6:false jdk7:true
    }
}
