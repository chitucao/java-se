package com.chitucao.thread.utils;

public class RunnableTest {

    public static void main(String[] args) {
        new aa().run();
    }

    static class aa implements Runnable{

        @Override
        public void run() {
            System.out.println("哈哈哈");
        }
    }
}
