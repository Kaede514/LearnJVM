package com.kaede.chapter08;

/**
 * -Xms600M -Xmx600M
 * 
 * �鿴��������������ı�����jinfo -flag NewRatio 8980
 * �鿴��������Eden����Survivor���ı�����jinfo -flag SurvivorRatio 8980
 * 
 * -XX:NewRatio��������������������ı�����Ĭ��ֵΪ2��-XX:NewRatio��
 * -XX:SurvivorRatio��������������Eden����Survivor���ı�����Ĭ��ֵΪ8������������Ӧ������ԣ�
 *                    ʵ����Ϊ6��Eden:Survivor0:Survivor1 = 6:1:1��
 * -XX:-UseAdaptiveSizePolicy���ر�����Ӧ���ڴ������ƣ���ʱ�ò�����
 * -Xmn�������������Ŀռ�Ĵ�С����������˵Ļ���С���������ֳ�ͻ�����Ϊ׼��һ�㲻���ã�
 */

public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("�������...");

        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
