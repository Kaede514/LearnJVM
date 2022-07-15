package com.kaede.chapter18;

public class IntegerTest {
    public static void main(String[] args) {
        //自动装箱
        Integer x = 5;
        int y = 5;
        //自动拆箱（可在字节码中看到）
        System.out.println(x == y);
        
        Integer i1 = 10;
        Integer i2 = 10;
        //看看底层源码，-128到127间值的Integer对象统一在一个数组中分配同一个引用
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
    }
}
