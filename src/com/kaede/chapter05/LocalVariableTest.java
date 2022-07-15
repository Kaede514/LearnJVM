package com.kaede.chapter05;

import java.util.Date;

@SuppressWarnings("all")
public class LocalVariableTest {
    private int count = 0;

    public static void main(String[] args) {
        //javap -v .\LocalVariableTest.class�������������оֲ��������п���    
        /**
         * LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      15     0  args   [Ljava/lang/String;
            8       7     1  test   Lcom/kaede/chapter05/LocalVariableTest;
           10       5     2   num   I
         */
        //��jclasslib�򿪲鿴
        LocalVariableTest test = new LocalVariableTest();
        int num = 0;
        test.test1();
        LocalVariableTest.testStatic();
        test.test2();
    }

    public void test1() {
        /**
         *  LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      12     0  this   Lcom/kaede/chapter05/LocalVariableTest;
            8       4     1  date   Ljava/util/Date;
           11       1     2  name   Ljava/lang/String;
         */
        Date date = new Date();
        String name = "kaede";
        System.out.println(date + name);
    }

    public static void testStatic() {
        LocalVariableTest test = new LocalVariableTest();
        Date date = new Date();
        int count = 10;
        // ��Ϊthis�������ڵ�ǰ�����ľֲ��������У���
        // System.out.println(this.count);
    }

    public void test2() {
        int i = 1;
        //double��long����ռ2���ۣ��������ռһ���ۣ������������ͣ�
        long x = -1;
        double j = 2;
        LocalVariableTest test= new LocalVariableTest();
        float k = 3;
    }   

    public void test3() {
        //�ֲ�����������Ϊ3
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //����cʹ��֮ǰ�Ѿ����ٵı���bռ�ݵ�slotλ��
        int c = a + 1;
    }
}
