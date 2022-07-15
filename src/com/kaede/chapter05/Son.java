package com.kaede.chapter05;

/**
 * 如果方法在编译期就确定了具体的调用版本，这个版本在运行时是不可变的，这样的方法称为非虚方法
 * 
 * 静态方法、私有方法、final方法、实例构造器和父类方法都是非虚方法
 * 
 * 其他方法称为虚方法
 */

public class Son extends Father{
    public Son() {
        //invokespecial
        super();
    }

    public Son(int age) {
        //invokespecial
        this();
    }

    //不是重写父类的静态方法
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    @SuppressWarnings("all")
    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    @SuppressWarnings("all")
    public void show() {
        //invokestatic
        showStatic("kaede");
        //invokestatic
        super.showStatic("good");
        //invokespecial 
        showPrivate("hello");
        //invokespecial
        super.showCommon();
        //invokevirtual
        //因为此方法声明为final，不能被子类重写，所以也认为该方法为非虚方法
        showFinal();
        //invokespecial
        super.showFinal();
        //invokevirtual
        showCommon();
        //invokevirtual
        info();

        MethodInterface in = null;
        //invokeinterface
        in.method();
    }

    public void info() {

    }
}

class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

interface MethodInterface {
    void method();
}