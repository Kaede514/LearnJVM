package com.kaede.chapter08;

/**
 * ���Զѿռ䳣�õ�jvm������
 * -XX:+PrintFlagsInitial���鿴���еĲ�����Ĭ�ϳ�ʼֵ
 * -XX:+PrintFlagsFinal���鿴���еĲ���������ֵ�����ܻ�����޸ģ������ǳ�ʼֵ��
 *      ����鿴ĳ��������ָ�jpsL���鿴��ǰ�����еĽ���
 *                            �� jinfo -flag SurvivorRatio ����id
 * -Xms����ʼ�ѿռ��ڴ棨Ĭ��Ϊ�����ڴ��1/64��
 * -Xmx�����ѿռ��ڴ棨Ĭ��Ϊ�����ڴ��1/4��
 * -XX:NewRatio= ��������������������ڶѽṹ��ռ��
 * -XX:SurvivorRatio= ��������������Eden��S0/S1�ռ�ı���
 * -XX:MaxTenuringThreshold= �������������������������
 * -XX:+PrintGCDetails�������ϸ��GC������־
 *  ��ӡGC��Ҫ��Ϣ����1��-XX:+PrintGC ��2��-verbose:gc
 * -XX:HandlePromotionFailure���Ƿ����ÿռ���䵣����java7��Ϊ�������ر���Ч��
 */

public class HeapArgsTest {
    public static void main(String[] args) {
        
    }
}
