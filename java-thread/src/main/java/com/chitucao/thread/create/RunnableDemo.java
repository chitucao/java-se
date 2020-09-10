package com.chitucao.thread.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author DennyFly
 * @since 2020/3/5 17:28
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        int coreSize = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(coreSize);
        pool.execute(new RunnableDemo());
        pool.shutdown();
    }
}
