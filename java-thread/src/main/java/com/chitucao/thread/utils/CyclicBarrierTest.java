package com.chitucao.thread.utils;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier cb = new CyclicBarrier(int parties) 接受一个整数型的参数。
 * 线程可以通过cb.await()等待，只要正在等待的线程数目达到设定的参数，所有等待的线程就会恢复执行。
 * CyclicBarrier 与 CountDownLatch 相似，都是要达到一样的人数才可以执行某些操作，只不过 CountDownLatch 是减操作，而 CyclicBarrier 是加操作。
 * 与 CyclicBarrier 相似的事件是集合点，即我们 5 个人周末一起去爬山，我们大家都要在某个地方等 5 个人到齐了再出发。
 *
 * 下面设置了两个集合点，只有当全部人到齐了第一个集合点之后，才会继续前往下一个集合点。
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);  //一共要等到几个线程才继续执行
        for(int i = 1; i <= 3; i++){
            Runnable runnable = () -> {
                try{
                    Thread.sleep((long)(Math.random() * 10000));
                    System.out.println(Thread.currentThread().getName() + "已经到达集合点A，正在等待。目前已有" + (cb.getNumberWaiting() + 1) + "个线程在等待" );
                    cb.await();
                    System.out.println("全部线程到达A集合点");

                    Thread.sleep((long)(Math.random() * 10000));
                    System.out.println(Thread.currentThread().getName() + "已经到达集合点B，正在等待。目前已有" + (cb.getNumberWaiting() + 1) + "个线程在等待" );
                    cb.await();
                    System.out.println("全部线程到达B集合点");
                }catch(Exception e){
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }
    }
}
