package com.markus.advanced.concurrency;

import com.markus.advanced.concurrency.task.SafeIncrementByReentrantLockTask;
import com.markus.advanced.concurrency.task.SafeIncrementBySynchronizedTask;

/**
 * @author: markus
 * @date: 2024/4/10 11:30 PM
 * @Description: 使用显式锁保证数据安全
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedMemory sharedMemory = new SharedMemory();
        Thread thread1 = new Thread(new SafeIncrementBySynchronizedTask(sharedMemory));
        Thread thread2 = new Thread(new SafeIncrementBySynchronizedTask(sharedMemory));
        // 开启两个工作线程
        thread1.start();
        thread2.start();
        // 等待两个工作线程将任务执行完成
        thread1.join();
        thread2.join();
        // 值会是 200000 的值
        System.out.println(sharedMemory.getCount());
    }
}
