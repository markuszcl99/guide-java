package com.markus.desgin.mode.structure.decorator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/13
 * @Description:
 */
public class DecoratorPatternDemo {
  public static void main(String[] args) {
    Car car = new BlueColorCar(new XiaomiSu7());
    car.running();

    System.out.println();
    car = new BlackColorCar(new XiaomiSu7());
    car.running();

    System.out.println();
    car = new BlueColorCar(new Magotan());
    car.running();

    System.out.println();
    car = new BlackColorCar(new Magotan());
    car.running();
  }
}
