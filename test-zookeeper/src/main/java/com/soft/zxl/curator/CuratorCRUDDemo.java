package com.soft.zxl.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

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
        System.out.printf("" + checkExits());
        selectNode();
        updateNode();
        selectNode();
        deleteNode();
        System.out.printf("" + checkExits());
    }

    public static void createNode() {
        try {
            client.create().forPath(PATH, "create".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateNode() {
        try {
            client.setData().forPath(PATH, "update".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectNode() {
        try {
            byte[] bytes = client.getData().forPath(PATH);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNode() {
        try {
            client.delete().forPath(PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkExits() {
        Stat stat = null;
        try {
            stat = client.checkExists().forPath(PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != stat) {
            return true;
        } else {
            return false;
        }
    }
}
