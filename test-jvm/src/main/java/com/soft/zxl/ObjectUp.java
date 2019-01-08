package com.soft.zxl;

/**
 * @program: test
 * @description: 模拟对象经过MinorGC后晋升到老年代（默认的晋升条件是年龄=15，
 * 也就意味着经历15次MinorGc后仍存活的对象晋升到老年代）通过jvm参数MaxTenuringThreshold=1可以指定晋升条件，
 * 1意味着经历一次MinorGC后存活的对象将被晋升到老年代
 * @author: zhaoxl
 * @create: 2019-01-08 15:58
 **/
public class ObjectUp {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参 数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
