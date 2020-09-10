package com.chitucao.thread.waitnotify;

public class ThreadB extends Thread {
    private Object lock = new Object();


    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("start ThreadB");
            //唤醒被阻塞的线程
            //此时还没有释放锁，只是通知其它线程在当前线程释放锁后竞争锁
            lock.notify();
            System.out.println("end ThreadB");
        }
    }
}
