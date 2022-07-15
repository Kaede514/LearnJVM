package com.kaede.chapter20;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class LoadingTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        try {
            //clazz在局部变量表中，Class实例在堆中，java.lang.String在方法区中
            //clazz指向堆中的Class实例对象，Class实例对象指向方法区中的String，反射的原理就是这样
            Class clazz = Class.forName("java.lang.String");
            //获取当前运行时类声明的所有方法
            Method[] ms = clazz.getDeclaredMethods();
            for(Method m : ms) {
                //获取方法的修饰符
                String mod = Modifier.toString(m.getModifiers());
                System.out.print(mod + " ");
                String returnType = m.getReturnType().toString();
                System.out.print(returnType + " ");
                System.out.print(m.getName() + "(");
                Class<?>[] ps = m.getParameterTypes();
                if(ps.length == 0) {
                    System.out.println(")");
                }
                for(int i = 0; i < ps.length; i++) {
                    char end = (i == ps.length - 1) ? ')' : ',';
                    System.out.print(ps[i].getSimpleName() + end);
                } 
                System.out.println();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
