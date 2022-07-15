package com.kaede.chapter08;

import java.util.List;
import java.util.ArrayList;

/**
 * 测试MinorGC(YoungGC)、MajorGC(OldGC)、FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */

public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "star-lunar";
            while(true) {
                list.add(a);
                a += a;
                i++;
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }
}
