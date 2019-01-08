package com.soft.zxl;

/**
 * @program: test
 * @description: 满足同年龄对象大小大于survivor空间一半，allocation1、allocation2会在年龄不足15时进入老年代
 * @author: zhaoxl
 * @create: 2019-01-08 16:40
 **/
public class DynamicAgeUp {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参 数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        //allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold2();
    }
}
