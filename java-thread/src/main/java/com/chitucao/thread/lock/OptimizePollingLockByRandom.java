package com.chitucao.thread.lock;

import org.junit.Test;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dennyfly
 * @since 2022/2/7 17:52
 * 添加最大轮询次数优化轮询锁
 */
public class OptimizePollingLockByRandom {

    private static Random rdm = new Random();

    @Test
    public void testOptimizeByRandom() {
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
                while (true) {
                    lockB.lock(); // 加锁
                    System.out.println("线程 2:获取到锁 B!");
                    try {
                        System.out.println("线程 2:等待获取 A...");
                        lockA.lock(); // 加锁
                        try {
                            System.out.println("线程 2:获取到锁 A!");
                        } finally {
                            lockA.unlock(); // 释放锁
                        }
                    } finally {
                        lockB.unlock(); // 释放锁
                    }
                    // 等待一秒之后继续执行
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
     */
    public static void pollingLock(Lock lockA, Lock lockB, int maxCount) {
        // 循环次数计数器
        int count = 0;
        while (true) {
            if (lockA.tryLock()) { // 尝试获取锁
                System.out.println("线程 1:获取到锁 A!");
                try {
                    Thread.sleep(100); // 等待 0.1s(获取锁需要的时间)
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

            // 等待一定时间(固定时间 + 随机时间)之后再继续尝试获取锁
            try {
                Thread.sleep(300 + rdm.nextInt(8) * 100); // 固定时间 + 随机时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
