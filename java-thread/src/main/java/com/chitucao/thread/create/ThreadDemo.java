package com.chitucao.thread.create;

/**
 * @author DennyFly
 * @since 2020/3/5 17:22
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        ThreadDemo myThread1 = new ThreadDemo();
        ThreadDemo myThread2 = new ThreadDemo();

        myThread1.start();
        myThread2.start();
    }

}
