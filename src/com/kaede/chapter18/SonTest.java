package com.kaede.chapter18;

/**
 * 成员变量（非静态的）的赋值过程：（1）默认初始化
 *                              （2）显式初始化
 *                              （3）有了对象之后，可以“对象.属性”或“对象.方法”的方式对成员变量进行赋值
 * 
 * 创建一个对象时首先对成员变量进行默认初始化（0、null），然后调用的是构造方法中的第一句super()(可能根据
 * 情况不同有不同的参数)，然后进行构造方法外的成员变量显示初始化，最后执行构造方法中其余语句
 */

@SuppressWarnings("all")
public class SonTest {
    public static void main(String[] args) {
        Father father = new Father();  
        System.out.println(father.x);
        System.out.println("----------------------");
        //此时在父类构造器中this.print()的this是Son类的对象，故调用Son类中的print()，调用前对象
        //只进行了默认初始化，还未显示初始化
        Son son = new Son();
        System.out.println(son.x);
        System.out.println("----------------------");
        //此时在父类构造器中this.print()的this是Son类的对象，故调用Son类中的print()，调用前对象
        //只进行了默认初始化，还未显示初始化
        Father son1 = new Son();
        //对象的方法调用有多态性，但是属性调用没有，故调用的是父类的x
        System.out.println(son1.x);
    }
}

class Father {
    int x = 10;

    public Father() {
        //this.print()改为print()效果也一样，this是在调用该方法时传进来的
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Father.x = " + x);
    }
}

class Son extends Father {
    int x = 30;

    public Son() {
        this.print();
        x = 40;
    }

    public void print() {
        System.out.println("Son.x = " + x);
    }
}