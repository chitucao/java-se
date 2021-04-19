package com.chitucao.thread.atomic;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DennyFly
 * @since 2021/4/12 16:12
 */
@Slf4j
public class AtomicIntegerExample {
    //
//    private static final Logger log = LoggerFactory.getLogger(AtomicIntegerExample.class);
    // 请求总数
    public static int requestTotal = 500;
    // 并发执行的线程数
    public static int threadTotal = 20;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();//获取线程池
        final Semaphore semaphore = new Semaphore(threadTotal);//定义信号量
        final CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        for (int i = 0; i < requestTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count.get());
    }

    private static void add() {
        count.incrementAndGet();
    }
}
