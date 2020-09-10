package com.chitucao.thread.create;

import java.util.concurrent.*;

/**
 * @author DennyFly
 * @since 2020/3/5 17:24
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        int a=1; int b=2;
        System.out.println(a+b);
        return "执行结果:"+(a+b);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        CallableDemo callableDemo=new CallableDemo();
        Future<String> future=executorService.submit(callableDemo);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
