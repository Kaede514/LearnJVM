package com.kaede.chapter05;

import java.util.Date;

@SuppressWarnings("all")
public class LocalVariableTest {
    private int count = 0;

    public static void main(String[] args) {
        //javap -v .\LocalVariableTest.class反编译后可在其中局部变量表中看到    
        /**
         * LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      15     0  args   [Ljava/lang/String;
            8       7     1  test   Lcom/kaede/chapter05/LocalVariableTest;
           10       5     2   num   I
         */
        //用jclasslib打开查看
        LocalVariableTest test = new LocalVariableTest();
        int num = 0;
        test.test1();
        LocalVariableTest.testStatic();
        test.test2();
    }

    public void test1() {
        /**
         *  LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      12     0  this   Lcom/kaede/chapter05/LocalVariableTest;
            8       4     1  date   Ljava/util/Date;
           11       1     2  name   Ljava/lang/String;
         */
        Date date = new Date();
        String name = "kaede";
        System.out.println(date + name);
    }

    public static void testStatic() {
        LocalVariableTest test = new LocalVariableTest();
        Date date = new Date();
        int count = 10;
        // 因为this不存在于当前方法的局部变量表中！！
        // System.out.println(this.count);
    }

    public void test2() {
        int i = 1;
        //double、long类型占2个槽，别的类型占一个槽（包括引用类型）
        long x = -1;
        double j = 2;
        LocalVariableTest test= new LocalVariableTest();
        float k = 3;
    }   

    public void test3() {
        //局部变量最大槽数为3
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前已经销毁的变量b占据的slot位置
        int c = a + 1;
    }
}
