package com.markus.desgin.mode.singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/6
 * @Description: 单例模式四: 静态内部类
 */
public class StaticInnerClassSingleton {
  private static class Singleton {
    public static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
  }

  private StaticInnerClassSingleton() {
  }

  public static StaticInnerClassSingleton getInstance() {
    return Singleton.INSTANCE;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    StaticInnerClassSingleton singleton1 = getInstance();
    StaticInnerClassSingleton singleton2 = getInstance();

    System.out.println(singleton1 == singleton2);

    CompletableFuture<StaticInnerClassSingleton> future1 = CompletableFuture.supplyAsync(StaticInnerClassSingleton::getInstance);
    CompletableFuture<StaticInnerClassSingleton> future2 = CompletableFuture.supplyAsync(StaticInnerClassSingleton::getInstance);
    singleton1 = future1.get();
    singleton2 = future2.get();
    System.out.println(singleton1 == singleton2);
  }
}
