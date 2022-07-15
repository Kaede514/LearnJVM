package com.kaede.chapter16;

/**
 * «ø“˝”√≤‚ ‘
 */

@SuppressWarnings("all")
public class StrongReferenceTest {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("hello,lunar");
        StringBuilder str1 = str;
        str = null;
        System.gc();

        try {
            Thread.sleep(3000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(str);
    }
}
