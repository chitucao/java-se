package com.chitucao.thread.responsibility;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 */
public class MainApp {

    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor pool =
            new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE + 1, 0, TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(100),
                    new NameTreadFactory(),
                    new MyIgnorePolicy());

    static {
        pool.prestartAllCoreThreads(); // 预启动所有核心线程
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }


    static IRequestProcessor requestProcessor;

    public void setUp() {
        PrintProcessor printProcessor = new PrintProcessor();
        printProcessor.start();
        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        saveProcessor.start();

        requestProcessor = new PrevProcessor(saveProcessor);
        ((PrevProcessor) requestProcessor).start();
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.setUp();
        Request request = new Request();
        request.setName("Mic");

        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            Runnable task = () -> {
                requestProcessor.process(request);
                latch.countDown();
            };
            pool.execute(task);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("所有线程执行完成");
            e.printStackTrace();
        }
    }

}
