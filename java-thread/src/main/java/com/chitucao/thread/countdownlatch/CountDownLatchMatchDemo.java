package com.chitucao.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时门栓 CountDownLatch
 * 接受一个整数型的参数，可以通过countDownLatch.countDown()减少一个计时，countDownLatch.await()进行线程等待，等到countDownLatch中的计数到0之后就会恢复执行。
 * CountDownLatch 与 Semaphore 的作用完全不同，CountDownLatch 是类似于集合点的一个类，当调用者到达一个数目就会触发一些操作。
 * 而 Semaphore 是一个类似于锁队列的东西，锁用完了就是用完了，而不会触发操作。
 */
public class CountDownLatchMatchDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        //要等到3个运动都准备好了，裁判才能命令
        final CountDownLatch waitCd = new CountDownLatch(3);
        //裁判发1次命令，运动员就开始跑
        final CountDownLatch orderCd = new CountDownLatch(1);
        //要等到3个运动员到达终点，裁判才公布成绩
        final CountDownLatch scoreCd = new CountDownLatch(3);

        //模拟3个运动员
        for(int i = 1; i <= 3; i++){
            final int count = i;
            Runnable runnable = () -> {
                try{
                    System.out.println("运动员" + count + "站在起跑线准备比赛了!");
                    waitCd.countDown(); //准备好
                    orderCd.await();

                    Thread.sleep((long)(Math.random() * 10000));  //模拟运动员隔多久听到命令
                    System.out.println("运动员" + count + "听到开跑命令，开跑！");

                    Thread.sleep((long)(Math.random() * 10000));  //模拟运动员用多长时间跑到终点
                    System.out.println("运动员" + count + "跑到了终点!");
                    scoreCd.countDown();  //跑到终点
                }catch(Exception e){
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }

        //模拟裁判
        Runnable runnable = () -> {
            try{
                System.out.println("裁判已到位，正在等待运动员做好准备！");
                waitCd.await();
                System.out.println("所有运动员已经就位，裁判准备发令！");
                Thread.sleep((long)(Math.random() * 10000));  //模拟裁判的准备时间
                System.out.println("裁判：比赛开始！ 跑！跑！跑！");
                orderCd.countDown();    //开跑
                scoreCd.await();
                System.out.println("所有运动员已经到达终点，裁判宣布成绩！");
            }catch(Exception e){
                e.printStackTrace();
            }
        };
        service.execute(runnable);

        service.shutdown();
    }
}
