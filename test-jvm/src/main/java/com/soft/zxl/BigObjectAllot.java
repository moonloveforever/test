package com.soft.zxl;

/**
 * @program: test
 * @description: -XX:PretenureSizeThreshold 直接分配大对象到老年代
 * 注意：
 * PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效，
 * Parallel Scavenge收集器不认识这个参数，Parallel Scavenge收集器一般并不需要设置。
 * 如果遇到必须使用此参数的场合，可以考虑ParNew加CMS的收集器组合。
 * @author: zhaoxl
 * @create: 2019-01-08 11:20
 **/
public class BigObjectAllot {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参 数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB]; //直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
