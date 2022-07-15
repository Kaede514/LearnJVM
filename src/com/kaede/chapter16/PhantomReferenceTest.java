package com.kaede.chapter16;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

@SuppressWarnings("all")
public class PhantomReferenceTest {
    private static PhantomReferenceTest obj;
    public static ReferenceQueue<PhantomReferenceTest> rq = null;   //���ö���

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);  //��Ϊ�ػ��߳�
        t.start();

        rq = new ReferenceQueue<>();
        obj = new PhantomReferenceTest();
        //������ PhantomReferenceTest �������ã���ָ�������ö���
        PhantomReference<PhantomReferenceTest> pref = new PhantomReference<PhantomReferenceTest>(obj, rq);
        try {
            //���ɻ�ȡ�������еĶ���
            System.out.println(pref.get());

            //������ȥ��
            obj = null;
            //��һ�ν���GC�����ڶ���ɸ��GC�޷����ոö���
            System.gc();    //һ����obj���գ��ͻὫ�������ô�ŵ����ö�����
            Thread.sleep(1000);     
            if(obj == null) {
                System.out.println("obj == null");
            } else {
                System.out.println("obj ����");
            }
            System.out.println("�ڶ���GC");
            obj = null;
            System.gc();   
            Thread.sleep(1000);
            if(obj == null) {
                System.out.println("obj == null");
            } else {
                System.out.println("obj ����");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static class CheckRefQueue extends Thread {
        @Override 
        public void run() {
            while(true) {
                if(rq != null) {
                    PhantomReference<PhantomReferenceTest> objt = null;
                    try {
                        objt = (PhantomReference<PhantomReferenceTest>) rq.remove();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    if(objt != null) {
                        System.out.println("׷���������չ��̣�PhantomReferenceTestʵ����GC��");
                    }
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("���õ�ǰ���finalize()����");
        obj = this;
    }
}
