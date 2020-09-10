package com.chitucao.thread.reentrant;

/**
 * @author DennyFly
 * @since 2020/3/6 14:45
 * Synchronize是可重入锁
 */
public class SynchronizeDemo {
    //锁是对象实例第一次获取
    public synchronized void demo() {
        System.out.println("begin:demo");
        demo2();
    }

    public void demo2() {
        System.out.println("begin:demo1");
        //对象实例的第二次获取
        synchronized (this) {
        }
    }

    public static void main(String[] args) {
        SynchronizeDemo rd = new SynchronizeDemo();
        new Thread(rd::demo).start();
    }
}
