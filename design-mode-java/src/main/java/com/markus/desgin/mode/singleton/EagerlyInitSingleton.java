package com.markus.desgin.mode.singleton;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/6
 * @Description: 单例模式一：急切初始化
 */
public class EagerlyInitSingleton {
  private static EagerlyInitSingleton INSTANCE = new EagerlyInitSingleton();

  public static EagerlyInitSingleton getInstance() {
    return INSTANCE;
  }

  public static void main(String[] args) {
    EagerlyInitSingleton eagerlyInitSingleton1 = getInstance();
    EagerlyInitSingleton eagerlyInitSingleton2 = getInstance();

    System.out.println(eagerlyInitSingleton1 == eagerlyInitSingleton2);

  }
}
