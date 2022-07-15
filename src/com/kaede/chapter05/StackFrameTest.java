package com.kaede.chapter05;

/**
 * 可用java -Xss1024 StackFrameTest来指定运行时的栈空间大小，在控制台
 * 编译注释掉包的程序，然后运行，默认为字节，可以用k,m,g等单位
 */

public class StackFrameTest {
    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        stackFrameTest.method1();
        // return; 存在，用来结束一个栈帧，可以在写代码中省略
    }

    public void method1() {
        System.out.println("method1()开始执行...");
        try {
            method2();      
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("method1()执行结束...");
    }

    public int method2() {
        System.out.println("method2()开始执行...");
        int i = 10;
        int m = (int) method3();
        // System.out.println(10 / 0);
        System.out.println("method2()即将结束...");
        return i + m;
    }

    public double method3() { 
        System.out.println("method3()开始执行...");
        double j = 20.0;
        method4();
        System.err.println("method3()即将结束...");
        return j;
    }

    //反编译javap -v .\StackFrameTest.class不包含私有方法，可以使用javap -p .\StackFrameTest.class显示出私有方法    
    private void method4() {
        System.out.println("method4()开始执行...");
        System.err.println("method4()执行结束...");
    }
}
