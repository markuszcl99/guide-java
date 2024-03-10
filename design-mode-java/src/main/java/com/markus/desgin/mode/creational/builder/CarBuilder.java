package com.markus.desgin.mode.creational.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public abstract class CarBuilder {
  protected Car car = new Car();

  public abstract CarBuilder buildWheel(Wheel wheel);

  public abstract CarBuilder buildSteeringWheel(SteeringWheel steeringWheel);

  public Car builder() {
    return car;
  }
}
