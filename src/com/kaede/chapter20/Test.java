package com.kaede.chapter20;

public class Test {
    //若为 public static String o = null; 则会有<clinit>方法生成，显示赋值为null
    public static String o = null;  //不会有<clinit>方法生成

    public static void main(String[] args) {
        System.out.println(1);
    }
}
