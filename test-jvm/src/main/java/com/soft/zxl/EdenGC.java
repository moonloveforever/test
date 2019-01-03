package com.soft.zxl;

/**
 * @program: test
 * @description: 新生代Minor GC
 * @author: zhaoxl
 * @create: 2019-01-03 22:33
 **/
public class EdenGC {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */

    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现一次MinorGC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
