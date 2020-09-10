package com.chitucao.thread.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptExceptionResetDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {//默认是false  _interrupted state?

                try {
                    TimeUnit.SECONDS.sleep(10); //中断一个处于阻塞状态的线程。join/wait/queue.take..
                    System.out.println("demo");
                } catch (InterruptedException e) {
                    //这个异常用于告诉当前线程外界有线程或者其它错误在中断当前线程 异常的抛出并不意味着线程必须终止，而是提醒当前线程有中断的操作发生
                    //在该异常抛出之前，中断标识会复位，此时获取到的中断标识为false
                    //在异常里，线程自己决定要不要中断当前线程，继续后续操作，这里加不加break都会继续执行下去
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("i:" + i);
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); //把isInterrupted设置成true

        //对于没有抛出中断异常的程序，直接中断，返回true
        //对于抛出中断异常的程序，如果在复位之前获取，会返回true(Main线程比中断线程快时)  大部分情况是返回false
        System.out.println(thread.isInterrupted()); //true
    }
}
