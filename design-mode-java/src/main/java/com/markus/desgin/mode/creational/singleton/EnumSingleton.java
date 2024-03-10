package com.markus.desgin.mode.creational.singleton;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/6
 * @Description: 单例模式五: 枚举
 */
public enum EnumSingleton {
  INSTANCE;

  public EnumSingleton getInstance(){
    return INSTANCE;
  }
}
