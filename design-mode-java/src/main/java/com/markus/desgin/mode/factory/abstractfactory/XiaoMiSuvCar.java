package com.markus.desgin.mode.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class XiaoMiSuvCar implements Car {
  @Override
  public void start() {
    System.out.println("小米 SUV 汽车启动...");
  }

  @Override
  public void stop() {
    System.out.println("小米 SUV 汽车停止...");
  }
}
