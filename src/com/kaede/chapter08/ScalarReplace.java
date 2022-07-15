package com.kaede.chapter08;

/**
 * �����滻���� 
 * ��δ�������ݵĶ�����Ϊ���ɳ�Ա�������滻��ԭʼ�������ͣ������洢���ڴ棬ֱ�Ӵ洢��CPU�Ĵ���
 * -Xms100m -Xmx100m [-XX:+DoEscapeAnalysis] -XX:+PrintGC -XX:-EliminateAllocations
 * -Xms100m -Xmx100m [-XX:+DoEscapeAnalysis] -XX:+PrintGC
 * 
 * �����У��رձ����滻�󣬻��ѵ�ʱ��Ϊ��55ms
 *        ���������滻��Ĭ�ϣ��󣬻��ѵ�ʱ��Ϊ��3ms
 * 
 * ���ݷ���Ŀǰ�����죬hotspotֻ���˱����滻��û��ʵ��ջ�Ϸ����ͬ��ʡ��
 * 
 * ����ʵ�����Ƿ����ڶ��ϵ�
 */

public class ScalarReplace {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for(int i = 0; i < 10000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("���ѵ�ʱ��Ϊ��" + (end - start) + "ms");
    }

    public static void alloc() {
        User u = new User();    //δ��������
        u.id = 5;
        u.name = "kaede";
    }

    public static class User{
        public int id;
        public String name;
    }
}
