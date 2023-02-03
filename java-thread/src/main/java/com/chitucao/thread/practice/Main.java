package com.chitucao.thread.practice;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author dennyfly
 * @since 2021/12/8 17:04
 */
public class Main {

    @Test
    public void testPrintABC() {
        OrderlyOperation operation = new OrderlyOperation();
        new Thread(() -> {
            operation.printABC(2);
        }, "C").start();

        new Thread(() -> {
            operation.printABC(0);
        }, "A").start();
        new Thread(() -> {
            operation.printABC(1);
        }, "B").start();


//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testPrintOddEven() {
        OrderlyOperation operation = new OrderlyOperation();
        new Thread(operation::printOddEven, "odd").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(operation::printOddEven, "even").start();
    }

    @Test
    public void testPrintABC2() {
        OrderlyOperation operation = new OrderlyOperation();
        new Thread(() -> {
            operation.printABC2(0);
        }, "thread1").start();
        new Thread(() -> {
            operation.printABC2(1);
        }, "thread2").start();
        new Thread(() -> {
            operation.printABC2(2);
        }, "thread3").start();

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
