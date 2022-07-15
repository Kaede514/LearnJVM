package com.kaede.chapter09;

/**
 * �������÷�������С����������
 * windows�£�-XX:MetaspaceSize��21M��-XX:MaxMetaspaceSize��ֵ��-1����û������
 * 
 * jdk7����ǰ��
 * -XX:PermSize=100M  -XX:MaxPermSize=100m
 * 
 * jkd8���Ժ�
 * -XX:MetaspaceSize=100m  -XX:MaxMetaspaceSize=100m
 * �鿴��jinfo -flag MetaspaceSize ����id   jinfo -flag MaxMetaspaceSize ����id
 * ����Metaspace������Խϸߣ���ֹƵ������GCӰ������
 */

public class MethodAreaTest {
    public static void main(String[] args) {
        System.out.println("start...");

        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
