package com.chitucao.thread.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DennyFly
 * @since 2020/3/6 14:50
 */
public class ReentrantDemo {
    private static int count = 0;
    static Lock lock = new ReentrantLock();

    public static void inc() {
        lock.lock();
        try {
            Thread.sleep(1);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                ReentrantDemo.inc();
            }).start();
            ;
        }
        Thread.sleep(3000);
        System.out.println("result:" + count);
    }

}
