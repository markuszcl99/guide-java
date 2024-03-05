package com.markus.desgin.mode.factory.simple;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class SimpleFactoryClient {
  public static void main(String[] args) {
    Car car = SimpleFactory.create(CarType.SANTANA);
    car.start();
    car.stop();

    car = SimpleFactory.create(CarType.XIAOMI);
    car.start();
    car.stop();
  }
}
