package com.markus.desgin.mode.singleton;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/6
 * @Description: 单例模式二: 懒加载模式
 */
public class LazyInitSingleton {
  private static LazyInitSingleton INSTANCE = null;

  public static synchronized LazyInitSingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new LazyInitSingleton();
    }
    return INSTANCE;
  }

  public static void main(String[] args) {
    LazyInitSingleton singleton1 = getInstance();
    LazyInitSingleton singleton2 = getInstance();

    System.out.println(singleton1 == singleton2);

  }
}
