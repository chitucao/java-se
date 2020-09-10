package com.chitucao.thread.utils;

public class ThreadControl {

    public static void main(String[] args) {
//        testJoin();
        new ThreadControl().testWaitNotify();
    }


    /**
     * join()   等待阻塞
     * 让一个线程等待另一个线程完成才继续执行。如A线程线程执行体中调用B线程的join()方法，则A线程被阻塞，知道B线程执行完为止，A才能得以继续执行。
     */
    private static void testJoin() {
        Thread thread = new Thread(() -> {
            System.out.println("I'm the thread.");
            try {
                Thread.sleep(2000);  //让其休眠2秒，测试主线程是否等待线程执行完再执行
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();    //让main线程等待线程执行完再执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Main Thread is Running over.");
    }


    /**
     * wait()/notify()   锁阻塞
     * wait() 和 notify() 方法的调用需要调用的方法有一个锁对象，主要用于进行不同线程之间的同步协作，常见的有生产者消费者模型。
     */
    private void testWaitNotify() {
        final ProduceConsumer pc = new ProduceConsumer();
        //生产者线程
        new Thread() {
            @Override
            public void run() {
                //生产10次
                for (int i = 0; i < 5; i++) {
                    System.out.println("Ready to Produce:" + (i + 1));
                    pc.produce(i);
                }
            }
        }.start();
        //消费者线程
        new Thread() {
            @Override
            public void run() {
                //消费10次
                for (int j = 0; j < 5; j++) {
                    System.out.println("Ready to Consume:" + (j + 1));
                    pc.consume(j);
                }
            }
        }.start();
    }

    class ProduceConsumer {
        //生产者
        public synchronized void produce(int i) {
            if (isEmpty) {
                //没东西了，可以生产
                num = (int) (Math.random() * 100);
                System.out.println("Producer:" + (i + 1) + "," + num);
                isEmpty = false;
                notify();
            } else {
                try {
                    System.out.println("producer执行wait操作:" + (i + 1));
                    wait();
                    System.out.println("producer醒来:" + (i + 1));
                    num = (int) (Math.random() * 100);
                    System.out.println("Producer:" + (i + 1) + "," + num);
                    isEmpty = false;
                    notify();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        //消费者
        public synchronized void consume(int i) {
            if (!isEmpty) {
                System.out.println("Consumer:" + (i + 1) + "," + num);
                isEmpty = true;
                notify();
            } else {
                try {
                    System.out.println("consumer执行wait操作:" + (i + 1));
                    wait();
                    System.out.println("consumer醒来:" + (i + 1));
                    System.out.println("Consumer:" + (i + 1) + "," + num);
                    isEmpty = true;
                    notify();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public ProduceConsumer() {
            isEmpty = true; //默认为空
        }

        private boolean isEmpty;  //是否为空

        private int num; //生产的东西

        public boolean isEmpty() {
            return isEmpty;
        }

        public void setEmpty(boolean isEmpty) {
            this.isEmpty = isEmpty;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }


    /**
     * sleep()   其他类型阻塞
     * 让当前的正在执行的线程暂停指定的时间，并进入阻塞状态。直接使用 Thread.sleep(long millionSeconds) 就可以了
     */
    private void testOtherBlock() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Sleep 2 Seconds.");
            }
        };
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Awake");
    }
}
