package com.chitucao.thread.synchronize;

/**
 * @author DennyFly
 * @since 2020/3/5 19:01
 */
public class MultiThreadProblemDemo {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> inc()).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果" + count);
    }

    public static void inc() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
}
