package com.markus.desgin.mode.creational.factory.simple;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class SantanaCar implements Car{
  @Override
  public void start() {
    System.out.println("钥匙扭转启动...");
  }

  @Override
  public void stop() {
    System.out.println("钥匙扭转熄火...");
  }
}
