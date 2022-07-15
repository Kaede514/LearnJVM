package com.kaede.chapter20;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class LoadingTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        try {
            //clazz�ھֲ��������У�Classʵ���ڶ��У�java.lang.String�ڷ�������
            //clazzָ����е�Classʵ������Classʵ������ָ�򷽷����е�String�������ԭ���������
            Class clazz = Class.forName("java.lang.String");
            //��ȡ��ǰ����ʱ�����������з���
            Method[] ms = clazz.getDeclaredMethods();
            for(Method m : ms) {
                //��ȡ���������η�
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
