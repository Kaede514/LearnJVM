package com.kaede.chapter08;

/**
 * 逃逸分析
 * 如何快速判断是否发生了逃逸，就看new的对象是否可能在方法外被调用
 * 开发中能使用局部变量的，就不要在方法外定义（未逃逸的变量可直接放入栈空间）
 */

 @SuppressWarnings("all")
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    //方法返回EscapeAnalysis对象，发生逃逸
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    //为成员属性赋值，发生逃逸
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }

    //对象的作用域仅在当前方法中有效，没有发生逃逸
    public void useEscapeAnalysis() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    //引用成员变量的值，发生逃逸
    public void useEscapeAnalysis1() {
        EscapeAnalysis e = getInstance();
    }
}
