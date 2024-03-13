package com.markus.desgin.mode.structure.decorator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/13
 * @Description:
 */
public class BlackColorCar extends ColorCarDecorator{
  public BlackColorCar(Car car) {
    super(car);
  }

  @Override
  protected void before() {
    System.out.println("黑色的车启动");
  }

  @Override
  protected void after() {
    System.out.println("黑色的车熄火");
  }
}
