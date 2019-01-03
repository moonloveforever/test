package com.soft.zxl.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @program: test
 * @description: 连接工具类
 * @author: zhaoxl
 * @create: 2019-01-03 14:57
 **/
public class CuratorConnectUtil {

    //连接字符串
    final static String CONNECTSTRING = "localhost:2181";
    //重试间隔
    final static int retryTimeMs = 1000;
    //重试次数
    final static int maxRetries = 3;

    private static CuratorFramework client = null;

    private CuratorConnectUtil() {
    }

    public static CuratorFramework getInstance() {
        if (client == null) {
            client = CuratorFrameworkFactory.builder().connectString(CONNECTSTRING)
                    .retryPolicy(new ExponentialBackoffRetry(retryTimeMs, maxRetries)).build();
        }
        return client;
    }
}
