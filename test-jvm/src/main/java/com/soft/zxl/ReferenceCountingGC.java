package com.soft.zxl;

/**
 * @program: test
 * @description: testGC()方法执行后，objA和obhB会不会被GC呢？
 * @author: zhaoxl
 * @create: 2018-12-24 23:09
 **/
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    /**
     * 启动时设置jvm配置-XX:+PrintGCDetails
     */
    public static void main(String[] args) {
        testGC();
    }
}
