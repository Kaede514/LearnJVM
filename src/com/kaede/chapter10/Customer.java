package com.kaede.chapter10;

/**
 * ���Զ���ʵ�����Ĺ���
 * 
 * ����������Ը�ֵ�Ĳ�����
 * ��1�����Ե�Ĭ�ϳ�ʼ�� ��2����ʾ��ʼ�� ��3��������г�ʼ�� ��4���������г�ʼ��
 */

 @SuppressWarnings("all")
public class Customer {
    private int id = 1001;
    private String name;
    Account acct;
    {
        name = "�����ͻ�";
    }

    public Customer() {
        acct = new Account();
    }
}

class Account {

}
