package com.kaede.chapter18;

/**
 * ��Ա�������Ǿ�̬�ģ��ĸ�ֵ���̣���1��Ĭ�ϳ�ʼ��
 *                              ��2����ʽ��ʼ��
 *                              ��3�����˶���֮�󣬿��ԡ�����.���ԡ��򡰶���.�������ķ�ʽ�Գ�Ա�������и�ֵ
 * 
 * ����һ������ʱ���ȶԳ�Ա��������Ĭ�ϳ�ʼ����0��null����Ȼ����õ��ǹ��췽���еĵ�һ��super()(���ܸ���
 * �����ͬ�в�ͬ�Ĳ���)��Ȼ����й��췽����ĳ�Ա������ʾ��ʼ�������ִ�й��췽�����������
 */

@SuppressWarnings("all")
public class SonTest {
    public static void main(String[] args) {
        Father father = new Father();  
        System.out.println(father.x);
        System.out.println("----------------------");
        //��ʱ�ڸ��๹������this.print()��this��Son��Ķ��󣬹ʵ���Son���е�print()������ǰ����
        //ֻ������Ĭ�ϳ�ʼ������δ��ʾ��ʼ��
        Son son = new Son();
        System.out.println(son.x);
        System.out.println("----------------------");
        //��ʱ�ڸ��๹������this.print()��this��Son��Ķ��󣬹ʵ���Son���е�print()������ǰ����
        //ֻ������Ĭ�ϳ�ʼ������δ��ʾ��ʼ��
        Father son1 = new Son();
        //����ķ��������ж�̬�ԣ��������Ե���û�У��ʵ��õ��Ǹ����x
        System.out.println(son1.x);
    }
}

class Father {
    int x = 10;

    public Father() {
        //this.print()��Ϊprint()Ч��Ҳһ����this���ڵ��ø÷���ʱ��������
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