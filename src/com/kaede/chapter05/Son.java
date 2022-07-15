package com.kaede.chapter05;

/**
 * ��������ڱ����ھ�ȷ���˾���ĵ��ð汾������汾������ʱ�ǲ��ɱ�ģ������ķ�����Ϊ���鷽��
 * 
 * ��̬������˽�з�����final������ʵ���������͸��෽�����Ƿ��鷽��
 * 
 * ����������Ϊ�鷽��
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

    //������д����ľ�̬����
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
        //��Ϊ�˷�������Ϊfinal�����ܱ�������д������Ҳ��Ϊ�÷���Ϊ���鷽��
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
        System.out.println("father�Ĺ�����");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father ��ͨ����");
    }
}

interface MethodInterface {
    void method();
}