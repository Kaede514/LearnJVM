package com.kaede.chapter16;

/**
 * 注释掉包，.\src\com\kaede\chapter16\目录下编译运行即可
 * java -XX:+PrintGCDetails LocalVarGC
 * 
 * 学了jvm后面可知，有了包后类的全类名中是含有包的，直接运行java LocalVarGC是找不到类的，因为
 * 全类名是com.kaede.chapter16.LocalVarGC
 * 所以，编译含有包的类后，直接在src目录（即包所在目录）用java com.kaede.chapter16.LocalVarGC
 * 运行即可，通过字节码可以看出全类名没有包的话全类名就是LocalVarGC
 */

@SuppressWarnings("all")
public class LocalVarGC {
    public static void main(String[] args) {
        LocalVarGC l = new LocalVarGC();
        // l.localVarGC1();
        // l.localVarGC2();
        l.localVarGC3();
        // l.localVarGC4();
        // l.localVarGC5();
    }

    public void localVarGC1() {
        //不回收
        byte[] buffer = new byte[10 * 1024 * 1024];
        System.gc();
    }

    public void localVarGC2() {
        //回收
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();
    }

    public void localVarGC3() {
        //不回收，slot槽中还占用着位置1（0处为this）    
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGC4() {
        //回收，value顶掉了槽中位置1处的buffer
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
    }

    public void localVarGC5() {
        //回收
        localVarGC1();
        System.gc();
    }
}
