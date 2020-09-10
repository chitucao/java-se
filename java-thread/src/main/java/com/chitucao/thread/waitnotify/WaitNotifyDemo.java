package com.chitucao.thread.waitnotify;

public class WaitNotifyDemo {

    public static void main(String[] args) {

        //两个线程持有的是同一把锁
        Object lock=new Object();
        ThreadA threadA=new ThreadA(lock);
        threadA.start();
        ThreadB threadB=new ThreadB(lock);
        threadB.start();
    }
}
