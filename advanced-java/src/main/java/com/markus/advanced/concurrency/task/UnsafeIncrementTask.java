package com.markus.advanced.concurrency.task;

import com.markus.advanced.concurrency.SharedMemory;

/**
 * @author: markus
 * @date: 2024/4/10 11:33 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class UnsafeIncrementTask implements Runnable {

    private SharedMemory sharedMemory;

    public UnsafeIncrementTask(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            sharedMemory.unsafeIncrement();
        }
    }
}
