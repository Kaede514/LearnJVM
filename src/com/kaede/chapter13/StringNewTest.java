package com.kaede.chapter13;

/**
 * ��Ŀ��new String("ab")�ᴴ���������󣬿��ֽ����֪Ϊ2��
 *      һ������ʱ��new�ؼ����ڶѿռ��д�����
 *      ��һ�������ǣ��ַ����������еĶ����ֽ���ָ��:ldc
 * 
 * new String("a") + new String("b")�أ�
 *  ����1��new StringBuilder()
 *  ����2��new String("a")
 *  ����3���ַ����������е�"a"
 *  ����4��new String("b")
 *  ����5���ַ����������е�"b"
 * ��������StringBuilder��toString()��
 *  ����6��new String("ab") ������ʹ�õ����ַ������String�������������ַ������������ʲ�����볣�����У�
 *  ǿ��һ�£�toString()�����ĵ��ã����ַ�����������û������"ab"
 */

public class StringNewTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String str1 = new String("ab");

        String str2 = new String("a") + new String("b");
    }
}
