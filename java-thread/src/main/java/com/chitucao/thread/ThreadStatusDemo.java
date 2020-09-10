package com.chitucao.thread;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {

    public static void main(String[] args) {
        //超时等待
        new Thread(new BlockedDemo(), "Blocke01_Thread").start();
        //同步阻塞 竞争
        new Thread(new BlockedDemo(), "Blocke02_Thread").start();

        //等待
        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Wating_Thread").start();

        //超时等待
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Time_Waiting_Thread").start();
    }


    static class BlockedDemo extends Thread {

        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
