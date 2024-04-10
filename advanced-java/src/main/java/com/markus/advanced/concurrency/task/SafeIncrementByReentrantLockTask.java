package com.markus.advanced.concurrency.task;

import com.markus.advanced.concurrency.SharedMemory;

/**
 * @author: markus
 * @date: 2024/4/10 11:39 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SafeIncrementByReentrantLockTask implements Runnable {
    private SharedMemory sharedMemory;

    public SafeIncrementByReentrantLockTask(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            sharedMemory.safeIncrementByExplicitLock();
        }
    }
}
