package com.markus.desgin.mode.singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/6
 * @Description:
 */
public class DoubleCheckLockSingleton {
  private static volatile DoubleCheckLockSingleton INSTANCE;

  public static DoubleCheckLockSingleton getInstance() {
    if (INSTANCE == null) {
      synchronized (DoubleCheckLockSingleton.class) {
        if (INSTANCE == null) {
          INSTANCE = new DoubleCheckLockSingleton();
        }
      }
    }
    return INSTANCE;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    DoubleCheckLockSingleton singleton1 = getInstance();
    DoubleCheckLockSingleton singleton2 = getInstance();

    System.out.println(singleton1 == singleton2);

    CompletableFuture<DoubleCheckLockSingleton> future1 = CompletableFuture.supplyAsync(DoubleCheckLockSingleton::getInstance);
    CompletableFuture<DoubleCheckLockSingleton> future2 = CompletableFuture.supplyAsync(DoubleCheckLockSingleton::getInstance);
    singleton1 = future1.get();
    singleton2 = future2.get();
    System.out.println(singleton1 == singleton2);
  }
}
