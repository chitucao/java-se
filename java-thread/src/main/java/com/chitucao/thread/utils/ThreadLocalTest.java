package com.chitucao.thread.utils;

/**
 * ThreadLocal是一个关于创建线程局部变量的类。
 * 通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。
 * 而使用ThreadLocal创建的变量只能被当前线程访问，其他线程则无法访问和修改。
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
       new ThreadLocalTest().testInheritableThreadLocal();
    }

    //存储泛型
    private void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("droidyue.com");
                mStringThreadLocal.get();
            }
        };
        t.start();
    }

    /**
     * 赋值初始值
     */
    private void testInitValue() {
        ThreadLocal<String> mThreadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };

        ThreadLocal<String> mThreadLocalNew = ThreadLocal.withInitial(() -> Thread.currentThread().getName());
    }

    /**
     * 既然上面提到了ThreadLocal只对当前线程可见，是不是说ThreadLocal的值只能被一个线程访问呢？
     * 使用InheritableThreadLocal可以实现多个线程访问ThreadLocal的值。
     * 使用InheritableThreadLocal可以将某个线程的ThreadLocal值在其子线程创建时传递过去。
     * 因为在线程创建过程中，有相关的处理逻辑。
     */
    private void testInheritableThreadLocal() {
        final ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("droidyue.com");
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("testInheritableThreadLocal =" + threadLocal.get());
            }
        };
        t.start();
    }
}
