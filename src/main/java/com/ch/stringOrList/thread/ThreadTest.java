package com.ch.stringOrList.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0; // 初始化线程局部变量的值
            }
        };

        for (int i = 0; i < 5; i++) {
            Runnable worker = () -> {
                Integer current = threadLocal.get();
                System.out.println("Thread " + Thread.currentThread().getName() + " got value: " + current);
                threadLocal.set(current + 1); // 设置新的值
                System.out.println("Thread " + Thread.currentThread().getName() + " set value: " + threadLocal.get());
                threadLocal.remove(); // 清理ThreadLocal变量
            };
            executor.submit(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}
