package com.chitucao.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author DennyFly
 * @since 2020/3/13 17:57
 */
public class CountDownLatchBaseDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println("" + Thread.currentThread().getName() + "-执行中");
            countDownLatch.countDown();
            System.out.println("" + Thread.currentThread().getName() + "-执行完毕");
        }, "t1").start();
        new Thread(() -> {
            System.out.println("" + Thread.currentThread().getName() + "-执行中");
            countDownLatch.countDown();
            System.out.println("" + Thread.currentThread().getName() + "-执行完毕");
        }, "t2").start();
        new Thread(() -> {
            System.out.println("" + Thread.currentThread().getName() + "-执行中");
            countDownLatch.countDown();
            System.out.println("" + Thread.currentThread().getName() + "-执行完毕");
        }, "t3").start();
        countDownLatch.await();
        System.out.println("所有线程执行完毕");
    }

}
