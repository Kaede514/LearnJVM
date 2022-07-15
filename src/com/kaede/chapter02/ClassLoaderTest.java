package com.kaede.chapter02;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //��ȡϵͳ�������
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //��ȡ���ϲ㣬��չ�������
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        //��ȡ���ϲ㣬��������������ñ���C��C++��д�ģ��޷���ȡ��Java����
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        //��Ӧ�û��Զ�������˵��Ĭ��ʹ��ϵͳ�������
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        
        //String��ʹ����������������м��� --> Java�ĺ�����ⶼ��ʹ����������������м��ص�
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
