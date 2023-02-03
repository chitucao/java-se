package com.chitucao.thread.lock;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dennyfly
 * @since 2022/2/7 17:52
 * 添加最大轮询次数优化轮询锁
 */
public class OptimizePollingLockByCount {

    @Test
    public void testOptimizeByCount(){
        Lock lockA = new ReentrantLock(); // 创建锁 A
        Lock lockB = new ReentrantLock(); // 创建锁 B

        // 创建线程 1(使用轮询锁)
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用轮询锁
                pollingLock(lockA, lockB, 3);
            }
        });
        t1.start(); // 运行线程

        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockB.lock(); // 加锁
                System.out.println("线程 2:获取到锁 B!");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程 2:等待获取 A...");
                    lockA.lock(); // 加锁
                    try {
                        System.out.println("线程 2:获取到锁 A!");
                    } finally {
                        lockA.unlock(); // 释放锁
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 线程 2 忘记释放锁资源
                    // lockB.unlock(); // 释放锁
                }
            }
        });
        t2.start(); // 运行线程

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 轮询锁
     *
     * maxCount：最大轮询次数
     */
    public static void pollingLock(Lock lockA, Lock lockB, int maxCount) {
        // 轮询次数计数器
        int count = 0;
        while (true) {
            if (lockA.tryLock()) { // 尝试获取锁
                System.out.println("线程 1:获取到锁 A!");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程 1:等待获取 B...");
                    if (lockB.tryLock()) { // 尝试获取锁
                        try {
                            System.out.println("线程 1:获取到锁 B!");
                        } finally {
                            lockB.unlock(); // 释放锁
                            System.out.println("线程 1:释放锁 B.");
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock(); // 释放锁
                    System.out.println("线程 1:释放锁 A.");
                }
            }

            // 判断是否已经超过最大次数限制
            if (count++ > maxCount) {
                // 终止循环
                System.out.println("轮询锁获取失败,记录日志或执行其他失败策略");
                return;
            }

            // 等待一秒再继续尝试获取锁
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
