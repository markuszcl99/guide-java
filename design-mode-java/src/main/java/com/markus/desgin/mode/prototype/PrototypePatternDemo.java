package com.markus.desgin.mode.prototype;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class PrototypePatternDemo {
  public static void main(String[] args) {
    Car car = CarCache.getCar("Xiaomi");
    car.drive();

    car = CarCache.getCar("BYD");
    car.drive();

    Car car2 = CarCache.getCar("BYD");
    System.out.println("car == car2 : " + (car == car2));
  }
}
