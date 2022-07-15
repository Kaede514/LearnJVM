package com.kaede.chapter08;

/**
 * -Xms600M -Xmx600M
 * 
 * 查看新生代与老年代的比例：jinfo -flag NewRatio 8980
 * 查看新生代中Eden区和Survivor区的比例：jinfo -flag SurvivorRatio 8980
 * 
 * -XX:NewRatio：设置新生代与老年代的比例，默认值为2（-XX:NewRatio）
 * -XX:SurvivorRatio：设置新生代中Eden区和Survivor区的比例，默认值为8，但由于自适应分配策略，
 *                    实际上为6（Eden:Survivor0:Survivor1 = 6:1:1）
 * -XX:-UseAdaptiveSizePolicy：关闭自适应的内存分配机制（暂时用不到）
 * -Xmn：设置新生代的空间的大小（如果设置了的话大小分配若出现冲突以这个为准，一般不设置）
 */

public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("打个酱油...");

        try {
            Thread.sleep(1000000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
