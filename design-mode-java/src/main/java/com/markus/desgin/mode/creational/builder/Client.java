package com.markus.desgin.mode.creational.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class Client {
  public static void main(String[] args) {
    CarBuilder carBuilder = new CommonCarBuilder();
    Director<Car> director = new XiaoMiDirector(carBuilder);
    Car car = director.construct();
    System.out.println(car);
  }
}
