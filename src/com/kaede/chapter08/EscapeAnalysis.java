package com.kaede.chapter08;

/**
 * ���ݷ���
 * ��ο����ж��Ƿ��������ݣ��Ϳ�new�Ķ����Ƿ�����ڷ����ⱻ����
 * ��������ʹ�þֲ������ģ��Ͳ�Ҫ�ڷ����ⶨ�壨δ���ݵı�����ֱ�ӷ���ջ�ռ䣩
 */

 @SuppressWarnings("all")
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    //��������EscapeAnalysis���󣬷�������
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    //Ϊ��Ա���Ը�ֵ����������
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }

    //�������������ڵ�ǰ��������Ч��û�з�������
    public void useEscapeAnalysis() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    //���ó�Ա������ֵ����������
    public void useEscapeAnalysis1() {
        EscapeAnalysis e = getInstance();
    }
}
