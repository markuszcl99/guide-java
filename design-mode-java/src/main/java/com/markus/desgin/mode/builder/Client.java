package com.markus.desgin.mode.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class Client {
  public static void main(String[] args) {
    CarBuilder carBuilder = new ConcreteCarBuilder();
    Director<Car> director = new XiaoMiDirector(carBuilder);
    Car car = director.construct();
    System.out.println(car);
  }
}
