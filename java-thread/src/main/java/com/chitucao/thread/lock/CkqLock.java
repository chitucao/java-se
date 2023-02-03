package com.chitucao.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chitucao
 * @since 2022/10/13 14:51
 */
public class CkqLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println("线程" + thread + "已加入");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
        System.out.println("线程" + thread + "获取锁成功");
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println("线程" + thread + "释放锁成功");
    }

    public static void main(String[] args) {
        CkqLock ckqLock = new CkqLock();

        new Thread(() -> {
            ckqLock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ckqLock.unLock();
        }, "线程1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            ckqLock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ckqLock.unLock();
        }, "线程2").start();
    }
}
