package com.chitucao.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author DennyFly
 * @since 2020/4/14 15:59
 */
public class ScheduledThreadPoolDemo {

//    private static final int corePoolSize = Runtime.getRuntime().availableProcessors();
//
//    /**
//     * 微信消息定时发送线程池
//     */
//    private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10L, TimeUnit.SECONDS,
//            new DelayedWorkQueue());

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        //延迟2秒后执行该任务
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {

            }
        }, 2, TimeUnit.SECONDS);
    }

}
