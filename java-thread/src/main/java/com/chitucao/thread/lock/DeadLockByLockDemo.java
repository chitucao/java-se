package com.chitucao.thread.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockByLockDemo {

    @Test
    public void testDeadLock() {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        new Thread(() -> {
            try {
                lockA.lock();
                System.out.println("线程 1:获取到锁 A!");
                Thread.sleep(1000);

                System.out.println("线程 1:等待获取 B...");
                try {
                    lockB.lock();
                    System.out.println("线程 1:获取到锁 B!");
                } finally {
                    lockB.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lockB.lock();
                System.out.println("线程 2:获取到锁 B!");
                Thread.sleep(1000);

                System.out.println("线程 2:等待获取 A...");
                try {
                    lockA.lock();
                    System.out.println("线程 2:获取到锁 A!");
                } finally {
                    lockA.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockB.unlock();
            }
        }).start();
    }
}
