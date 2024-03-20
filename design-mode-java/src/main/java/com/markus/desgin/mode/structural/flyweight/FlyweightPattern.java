package com.markus.desgin.mode.structural.flyweight;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/20
 * @Description:
 */
public class FlyweightPattern {
  public static void main(String[] args) {
    CarFactory factory = new XiaomiCarFactory();
    Car markusZhangCar = factory.getCar("MarkusZhang");
    markusZhangCar.drive();

    Car car2 = factory.getCar("MarkusZhang");
    System.out.println(car2 == markusZhangCar);
  }
}
