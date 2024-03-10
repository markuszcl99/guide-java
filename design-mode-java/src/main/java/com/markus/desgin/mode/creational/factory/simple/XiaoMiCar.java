package com.markus.desgin.mode.creational.factory.simple;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class XiaoMiCar implements Car{
  @Override
  public void start() {
    System.out.println("按钮启动...");
  }

  @Override
  public void stop() {
    System.out.println("按钮停止...");
  }
}
