package com.kaede.chapter02;

public class ClinitTest1 {
    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        //�ȼ���Father�࣬��μ���Son��
        System.out.println(Son.B);;
    }
}
