package com.chitucao.thread.utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;


/**
 * 信号灯 Semaphore
 * Semaphore sp = new Semaphore(int permits) 接受一个整数型的参数，表示有几盏灯。
 * 线程可以通过semaphore.acquire()获取一盏信号灯，通过semaphore.release()释放。
 * 它与 Lock 的区别就是 Lock 只能是一个锁，而 Semaphore 更像是多个锁的一个集合，像一个阻塞队列一样，
 * 当队列中的锁用完了，而你又需要锁的时候，你就必须等待其他的线程释放锁。
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        final Semaphore sp = new Semaphore(1);  //只声明一盏信号灯
        //业务线程1
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "准备获取信号灯-A");
                sp.acquire();  //获取信号灯
                System.out.println(Thread.currentThread().getName() + "已获取信号灯-A");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        //业务线程2
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "准备获取信号灯-B");
                sp.acquire();  //获取信号灯
                System.out.println(Thread.currentThread().getName() + "已获取信号灯-B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        //业务线程3
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "准备获取信号灯-C");
                sp.acquire();  //获取信号灯
                System.out.println(Thread.currentThread().getName() + "已获取信号灯-C");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        //检查线程
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("每10s释放一次信号灯");
                sp.release();
                System.out.println("信号灯已释放");
            }
        }, 2000, 2000);    //每2秒释放一次信号灯
    }


}
