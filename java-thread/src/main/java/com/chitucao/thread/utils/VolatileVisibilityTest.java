package com.chitucao.thread.utils;

/**
 * 保证多个线程间的可见性
 */
public class VolatileVisibilityTest {

    public static void main(String args[]) {
        final Worker worker = new Worker();
        //Thread 1
        new Thread(() -> worker.work()).start();
        //Thread 2
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker.setDone(true);
            System.out.println("Work DONE!");
        }).start();
    }


    static class Worker {
        private volatile boolean done = false;

        public void setDone(boolean done) {
            this.done = done;
        }

        public void work() {
            while (!done) {
                System.out.println("Working..." + done);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
