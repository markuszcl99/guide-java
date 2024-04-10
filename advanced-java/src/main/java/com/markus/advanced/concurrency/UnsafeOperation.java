package com.markus.advanced.concurrency;

import com.markus.advanced.concurrency.task.UnsafeIncrementTask;

/**
 * @author: markus
 * @date: 2024/4/10 11:31 PM
 * @Description: 线程不安全操作
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class UnsafeOperation {
    public static void main(String[] args) throws InterruptedException {
        SharedMemory sharedMemory = new SharedMemory();
        Thread thread1 = new Thread(new UnsafeIncrementTask(sharedMemory));
        Thread thread2 = new Thread(new UnsafeIncrementTask(sharedMemory));
        // 开启两个工作线程
        thread1.start();
        thread2.start();
        // 等待两个工作线程将任务执行完成
        thread1.join();
        thread2.join();
        // 值会是一个 小于 200000 的值
        System.out.println(sharedMemory.getCount());
    }
}
