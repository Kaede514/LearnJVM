package com.kaede.chapter16;

/**
 * ע�͵�����.\src\com\kaede\chapter16\Ŀ¼�±������м���
 * java -XX:+PrintGCDetails LocalVarGC
 * 
 * ѧ��jvm�����֪�����˰������ȫ�������Ǻ��а��ģ�ֱ������java LocalVarGC���Ҳ�����ģ���Ϊ
 * ȫ������com.kaede.chapter16.LocalVarGC
 * ���ԣ����뺬�а������ֱ����srcĿ¼����������Ŀ¼����java com.kaede.chapter16.LocalVarGC
 * ���м��ɣ�ͨ���ֽ�����Կ���ȫ����û�а��Ļ�ȫ��������LocalVarGC
 */

@SuppressWarnings("all")
public class LocalVarGC {
    public static void main(String[] args) {
        LocalVarGC l = new LocalVarGC();
        // l.localVarGC1();
        // l.localVarGC2();
        l.localVarGC3();
        // l.localVarGC4();
        // l.localVarGC5();
    }

    public void localVarGC1() {
        //������
        byte[] buffer = new byte[10 * 1024 * 1024];
        System.gc();
    }

    public void localVarGC2() {
        //����
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();
    }

    public void localVarGC3() {
        //�����գ�slot���л�ռ����λ��1��0��Ϊthis��    
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGC4() {
        //���գ�value�����˲���λ��1����buffer
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
    }

    public void localVarGC5() {
        //����
        localVarGC1();
        System.gc();
    }
}
