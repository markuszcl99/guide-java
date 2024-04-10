package com.markus.advanced.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: markus
 * @date: 2024/4/10 11:30 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SharedMemory {
    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void unsafeIncrement() {
        count++;
    }

    public void safeIncrementByExplicitLock() {
        lock.lock();
        count++;
        lock.unlock();
    }

    public synchronized void safeIncrementBySynchronized() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
