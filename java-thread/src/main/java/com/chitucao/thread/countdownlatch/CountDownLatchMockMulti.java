package com.chitucao.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author DennyFly
 * @since 2020/3/13 18:00
 */
public class CountDownLatchMockMulti extends Thread{
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatchMockMulti().start();
        }
        countDownLatch.countDown();
    }

}
