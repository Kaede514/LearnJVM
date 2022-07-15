package com.kaede.chapter01;

/**
 * 进入存放字节码的目录，cd .\bin\com\kaede\chapter01\
 * 执行反编译，javap -v .\StackStruTest.class
 * 显示类信息：javap -p xxx
 * 反编译类（包含私有方法和属性）javap -v -p xxx
 * 
 * JVM中Java指令根据栈来设计，跨平台性号、指令集小、指令多，但执行性能比寄存器差
 */

public class StackStruTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // int i = 2 +3;
        int i = 2;
        int j = 3;
        int k = i + j;
    }
}
