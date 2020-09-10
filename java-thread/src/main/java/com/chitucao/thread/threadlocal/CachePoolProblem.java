package com.chitucao.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author DennyFly
 * @since 2020/3/12 10:26
 */
public class CachePoolProblem {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    private static ThreadLocal<Integer> variableHolder = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private int getValue() {
        return variableHolder.get();
    }

    private void remove() {
        variableHolder.remove();
    }

    private void incr() {
        variableHolder.set(getValue() + 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Runnable task = () -> {
                CachePoolProblem cachePoolProblem = new CachePoolProblem();
                int before = cachePoolProblem.getValue();
                cachePoolProblem.incr();
                int after = cachePoolProblem.getValue();
                System.out.println("before: " + before + ", after: " + after);
                //cachePoolProblem.remove();  对应web应用中过滤器可以后置处理可以remove
            };
            pool.execute(task);
        }
        pool.shutdown();
    }
}
