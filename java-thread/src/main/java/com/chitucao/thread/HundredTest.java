package com.chitucao.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chitucao
 * @since 2022/9/22 19:24
 * <p>
 * 步骤
 * 1.线程1 拿到0
 * 2.线程2 拿到0
 * 3.线程1 循环99次后写回主存    0-99     主存99
 * 4.线程2 循环1次后写回主存     0-1      主存1
 * 5.线程1 循环1次后等待写回主存 1-2...   主存1
 * 6.线程2 循环99次后写回主存    1-100    主存100
 * 7.线程1 写回主存              2...     主存2
 */
public class HundredTest {

    CountDownLatch countDownLatch;

    public HundredTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    int num = 0;

    /**
     * 从0写到99后释放
     */
    class Thread1 implements Runnable {

        private Lock lock;
        private Condition condition;

        public Thread1(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            // 步骤1
            int myNum = num;
            printStep("步骤1", myNum, num);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {
                // 步骤3
                for (int i = 0; i < 99; i++) {
                    myNum++;
                }
                num = myNum;
                printStep("步骤3", myNum, num);
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // 步骤5
                myNum = num;
                for (int i = 0; i < 1; i++) {
                    myNum++;
                }
                printStep("步骤5", myNum, num);
                try {
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // 步骤7
                num = myNum;
                printStep("步骤7", myNum, num);
                condition.signal();

            } finally {
                lock.unlock();
            }

            countDownLatch.countDown();
        }
    }

    class Thread2 implements Runnable {
        private Lock lock;
        private Condition condition;

        public Thread2(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            // 步骤2
            int myNum = 0;
            printStep("步骤2", myNum, num);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {

                // 步骤4
                for (int i = 0; i < 1; i++) {
                    myNum++;
                }
                num = myNum;
                printStep("步骤4", myNum, num);
                try {
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // 步骤6
                myNum = num;
                for (int i = 0; i < 99; i++) {
                    myNum++;
                }
                num = myNum;
                printStep("步骤6", myNum, num);
                try {
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } finally {
                lock.unlock();
            }
            countDownLatch.countDown();
        }
    }

    public static void printStep(String stepName, int local, int main) {
        String threadName = Thread.currentThread().getName();
        System.out.println(stepName + " " + threadName + " 工作内存：" + local + "  主内存：" + main);
    }

    public void testAdd() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new Thread1(lock, condition), "线程1").start();
        new Thread(new Thread2(lock, condition), "线程2").start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("最后结果:" + num);
    }


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        new HundredTest(latch).testAdd();
    }

}
