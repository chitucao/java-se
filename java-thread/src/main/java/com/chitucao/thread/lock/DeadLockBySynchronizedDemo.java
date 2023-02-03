package com.chitucao.thread.lock;

import org.junit.Test;

import java.io.IOException;

public class DeadLockBySynchronizedDemo {

    @Test
    public void testDeadLock() {
        Object lockA = new Object();
        Object lockB = new Object();

        new Thread(() -> {
            try {
                synchronized (lockA) {
                    System.out.println("线程 1:获取到锁 A!");
                    Thread.sleep(1000);

                    System.out.println("线程 1:等待获取 B...");
                    synchronized (lockB) {
                        System.out.println("线程 1:获取到锁 B!");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                synchronized (lockB) {
                    System.out.println("线程B获得了锁B");
                    Thread.sleep(1000);
                    System.out.println("线程B等待获取锁A");

                    synchronized (lockA) {
                        System.out.println("线程B获得了锁A");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
