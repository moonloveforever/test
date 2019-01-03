package com.soft.zxl.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.CountDownLatch;

/**
 * @program: test
 * @description: curator实现分布式锁demo
 * @author: zhaoxl
 * @create: 2019-01-03 13:21
 **/
public class RecipesLockDemo {
    final static String LOCK_PATH = "/curator_recipes";

    static CuratorFramework client = CuratorConnectUtil.getInstance();

    static int count = 10;

    public static int genarNo() {
        count--;
        return count;
    }

    public static void main(String[] args) {
        client.start();
        //声明一个 分布式可重入排它锁
        final InterProcessMutex lock = new InterProcessMutex(client, LOCK_PATH);
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                        //加锁
                        lock.acquire();
                        //业务逻辑
                        System.out.println("生成的订单号是：" + genarNo());
                    } catch (InterruptedException e) {
                    } catch (Exception e) {
                    } finally {
                        try {
                            //释放锁
                            lock.release();
                        } catch (Exception e) {
                        }
                    }

                }
            }, "Thread" + i).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        latch.countDown();
    }
}
