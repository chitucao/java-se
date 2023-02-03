package com.chitucao.thread.practice;

/**
 * @author dennyfly
 * @since 2021/12/8 15:41
 * 多线程顺序执行
 */
public class OrderlyOperation {

    private static final int n = 10;
    private int num;
    private static final Object LOCK = new Object();

    // 三个线程T1、T2、T3轮流打印ABC，打印n次，如ABCABCABCABC
    public void printABC(int targetNum) {
        for (int i = 0; i < n; i++) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }


    private volatile int count;

    // 两个线程交替打印1-100的奇偶数
    public void printOddEven() {
        synchronized (LOCK) {
            while (count < 10) {
                try {
                    System.out.print(Thread.currentThread().getName() + "：");
                    System.out.println(++count);
                    LOCK.notifyAll();
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 防止count=10后，while()循环不再执行，有子线程被阻塞未被唤醒，导致主线程不能退出
            LOCK.notifyAll();
        }
    }

    private final int maxNum = 100;

    // N个线程循环打印1-100
    public void printABC2(int targetNum) {
        while (true) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {
                    if (num >= maxNum) {
                        break;
                    }
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(num >= maxNum){
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName() + ": " + num);
                LOCK.notifyAll();
            }
        }

    }

}
