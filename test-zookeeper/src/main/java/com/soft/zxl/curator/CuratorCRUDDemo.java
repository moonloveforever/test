package com.soft.zxl.curator;

import org.apache.curator.framework.CuratorFramework;

/**
 * @program: test
 * @description: 简单的crud实现
 * @author: zhaoxl
 * @create: 2019-01-03 15:08
 **/
public class CuratorCRUDDemo {

    static CuratorFramework client = CuratorConnectUtil.getInstance();

    static String PATH = "/crud-test";

    public static void main(String[] args) {
        client.start();
        createNode();
    }

    public static void createNode(){
        try {
            client.create().forPath(PATH,"create".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
