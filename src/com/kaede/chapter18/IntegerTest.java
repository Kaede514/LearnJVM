package com.kaede.chapter18;

public class IntegerTest {
    public static void main(String[] args) {
        //�Զ�װ��
        Integer x = 5;
        int y = 5;
        //�Զ����䣨�����ֽ����п�����
        System.out.println(x == y);
        
        Integer i1 = 10;
        Integer i2 = 10;
        //�����ײ�Դ�룬-128��127��ֵ��Integer����ͳһ��һ�������з���ͬһ������
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
    }
}
