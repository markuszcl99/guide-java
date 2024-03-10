package com.markus.desgin.mode.creational.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class DaZhongSuvCar implements Car {
  @Override
  public void start() {
    System.out.println("大众 SUV 汽车启动...");
  }

  @Override
  public void stop() {
    System.out.println("大众 SUV 汽车停止...");
  }
}
