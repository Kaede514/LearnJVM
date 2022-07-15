package com.kaede.chapter08;

/**
 * 测试堆空间常用的jvm参数：
 * -XX:+PrintFlagsInitial：查看所有的参数的默认初始值
 * -XX:+PrintFlagsFinal：查看所有的参数的最终值（可能会存在修改，不再是初始值）
 *      具体查看某个参数的指令：jpsL：查看当前运行中的进程
 *                            如 jinfo -flag SurvivorRatio 进程id
 * -Xms：初始堆空间内存（默认为物理内存的1/64）
 * -Xmx：最大堆空间内存（默认为物理内存的1/4）
 * -XX:NewRatio= ：设置新生代与老年代在堆结构的占比
 * -XX:SurvivorRatio= ：设置新生代中Eden和S0/S1空间的比例
 * -XX:MaxTenuringThreshold= ：设置新生代垃圾的最大年龄
 * -XX:+PrintGCDetails：输出详细的GC处理日志
 *  打印GC简要信息：（1）-XX:+PrintGC （2）-verbose:gc
 * -XX:HandlePromotionFailure：是否设置空间分配担保（java7后为开启，关闭无效）
 */

public class HeapArgsTest {
    public static void main(String[] args) {
        
    }
}
